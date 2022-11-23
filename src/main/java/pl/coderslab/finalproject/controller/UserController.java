package pl.coderslab.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.dao.AdvertisingDao;
import pl.coderslab.finalproject.dao.BrandDao;
import pl.coderslab.finalproject.dao.CategoryDao;
import pl.coderslab.finalproject.model.Advertising;
import pl.coderslab.finalproject.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final AdvertisingDao advertisingDao;
    private final CategoryDao categoryDao;
    private final BrandDao brandDao;

    @RequestMapping(value = "/advertising/list", method = RequestMethod.GET)
    public String index(@AuthenticationPrincipal UserDetails customUser, Model model) {
        List<Advertising> adsList = advertisingDao.findAllWithUsername(customUser.getUsername());
        model.addAttribute("category", categoryDao.findAll());
        model.addAttribute("brand", brandDao.findAll());
        model.addAttribute("items", adsList);
        if (adsList.size() != 0) {
            return "/user/advertising-list";
        }
        return "no-results";
    }

    @RequestMapping(value = "/advertising/create", method = RequestMethod.GET)
    public String formCreate(Model model) {
        model.addAttribute("advertising", new Advertising());
        model.addAttribute("category", categoryDao.findAll());
        model.addAttribute("brand", brandDao.findAll());
        model.addAttribute("items", advertisingDao.findAll());
        return "/user/advertising-form";
    }

    @RequestMapping(value = "/advertising/create", method = RequestMethod.POST)
    public String submitCreate(@Valid @ModelAttribute Advertising advertising, BindingResult result, @AuthenticationPrincipal UserDetails user, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("category", categoryDao.findAll());
            model.addAttribute("brand", brandDao.findAll());
            model.addAttribute("items", advertisingDao.findAll());
            return "/user/advertising-form";
        }
        advertising.setUser(userService.findByUsername(user.getUsername()));
        advertisingDao.create(advertising);
        return "redirect:/user/advertising/list";
    }

    @RequestMapping(value = "/advertising/update/{id}", method = RequestMethod.GET)
    public String formUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("advertising", advertisingDao.findById(id));
        model.addAttribute("category", categoryDao.findAll());
        model.addAttribute("brand", brandDao.findAll());
        model.addAttribute("items", advertisingDao.findAll());
        return "/user/advertising-form";
    }

    @RequestMapping(value = "/advertising/update/{id}", method = RequestMethod.POST)
    public String submitUpdate(@PathVariable Long id, @Valid @ModelAttribute Advertising advertising, BindingResult result, @AuthenticationPrincipal UserDetails user, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("category", categoryDao.findAll());
            model.addAttribute("brand", brandDao.findAll());
            model.addAttribute("items", advertisingDao.findAll());
            return "/user/advertising-form";
        }
        if (id.equals(advertising.getId())) {
            advertising.setUser(userService.findByUsername(user.getUsername()));
            advertisingDao.update(advertising);
        }
        return "redirect:/user/advertising/list";
    }

    @RequestMapping(value = "/advertising/remove/{id}", method = RequestMethod.GET)
    public String formRemove(@PathVariable Long id, Model model) {
        model.addAttribute("advertising", advertisingDao.findById(id));
        return "/user/advertising-remove";
    }

    @RequestMapping(value = "/advertising/remove/{id}", method = RequestMethod.POST)
    public String submitRemove(@PathVariable Long id, @ModelAttribute Advertising advertising, @RequestParam String remove) {
        if (remove.equals("Tak")) {
            advertisingDao.remove(advertising);
        }
        return "redirect:/user/advertising/list";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public String changePassword() {
        return "/user/change-password";
    }
}