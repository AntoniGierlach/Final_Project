package pl.coderslab.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.dao.AdvertisingDao;
import pl.coderslab.finalproject.dao.BrandDao;
import pl.coderslab.finalproject.dao.CategoryDao;
import pl.coderslab.finalproject.model.Advertising;
import pl.coderslab.finalproject.model.Brand;
import pl.coderslab.finalproject.model.Category;
import pl.coderslab.finalproject.repository.AdvertisingRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/advertising")
public class AdvertisingController {

    private final AdvertisingRepository advertisingRepository;
    private final AdvertisingDao advertisingDao;
    private final CategoryDao categoryDao;
    private final BrandDao brandDao;

    @ModelAttribute("category")
    public List<Category> category() {
        return categoryDao.findAll();
    }

    @ModelAttribute("brand")
    public List<Brand> brand() {
        return brandDao.findAll();
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("item", advertisingDao.findById(id));
        return "/advertising-details";
    }

    @RequestMapping("/category/{id}")
    public String findAllByCategoryId(@PathVariable Long id, Model model) {
        List<Advertising> list = advertisingDao.findAllWithCategory(categoryDao.findById(id));
        model.addAttribute("items", advertisingDao.findAllWithCategory(categoryDao.findById(id)));
        if (list.size() != 0) {
            return "index";
        }
        return "no-results";
    }

    @RequestMapping("/brand/{id}")
    public String findAllByBrandId(@PathVariable Long id, Model model) {
        List<Advertising> list = advertisingDao.findAllWithBrand(brandDao.findById(id));
        model.addAttribute("items", advertisingDao.findAllWithBrand(brandDao.findById(id)));
        if (list.size() != 0) {
            return "index";
        }
        return "no-results";
    }

    @RequestMapping(value = "/mileage")
    public String findAllByRatingBetween(@RequestParam(name = "min") Integer min, @RequestParam(name = "max") Integer max, Model model) {
        List<Advertising> list = advertisingRepository.findQueryAllByMileageBetween(min, max);
        model.addAttribute("items", advertisingRepository.findQueryAllByMileageBetween(min, max));
        if (list.size() != 0) {
            return "index";
        }
        return "no-results";
    }

    @RequestMapping(value = "/price")
    public String findAllByPriceBetween(@RequestParam(name = "min") Integer min, @RequestParam(name = "max") Integer max, Model model) {
        List<Advertising> list = advertisingRepository.findQueryAllByPriceBetween(min, max);
        model.addAttribute("items", advertisingRepository.findQueryAllByPriceBetween(min, max));
        if (list.size() != 0) {
            return "index";
        }
        return "no-results";
    }

    @RequestMapping(value = "/sort/mileageMin")
    public String findAllSortByMileageAsc(Model model) {
        model.addAttribute("items", advertisingDao.findAllSortByMileageAsc());
        return "index";
    }

    @RequestMapping(value = "/sort/mileageMax")
    public String findAllSortByMileageDesc(Model model) {
        model.addAttribute("items", advertisingDao.findAllSortByMileageDesc());
        return "index";
    }

    @RequestMapping(value = "/sort/priceMin")
    public String findAllSortByPriceAsc(Model model) {
        model.addAttribute("items", advertisingDao.findAllSortByPriceAsc());
        return "index";
    }

    @RequestMapping(value = "/sort/priceMax")
    public String findAllSortByPriceDesc(Model model) {
        model.addAttribute("items", advertisingDao.findAllSortByPriceDesc());
        return "index";
    }

    @RequestMapping(value = "/sort/date")
    public String findAllSortByDateDesc(Model model) {
        model.addAttribute("items", advertisingDao.findAllSortByDateDesc());
        return "index";
    }
}