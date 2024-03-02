package findest.com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import findest.com.test.entity.Studies;
import findest.com.test.service.StudiesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class StudiesController {

    @Autowired
    StudiesService sServ;

    @RequestMapping(value = "/addStudy")
    public ModelAndView addStudy() {
        ModelAndView mav = new ModelAndView("/addStudy");
        return mav;
    }

    @RequestMapping(value = "/addStudydata", method = RequestMethod.POST)
    public String addStudyData(@RequestParam String name) {
        sServ.addStudies(name);
        return "redirect:/";
    }

    @RequestMapping(value = "/removeStudy/{id}", method = RequestMethod.GET)
    public String removeStudy(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            sServ.removeStudies(id);
            redirectAttributes.addFlashAttribute("successMessage", "Study successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error during deletion.");
        }
        return "redirect:/";
    }

    @GetMapping("/editStudy/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Studies study = sServ.getStudies(id);
        model.addAttribute("study", study);
        return "editStudy";
    }

    @PostMapping("/updateStudy/{id}")
    public String updateStudy(@PathVariable("id") Integer id, @RequestParam String name,
            RedirectAttributes redirectAttributes) {
        if (name == null || name.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "The name cannot be empty.");
            return "redirect:/editStudy/" + id;
        }
        sServ.updateStudiesName(id, name);
        redirectAttributes.addFlashAttribute("success", "Study updated successfully");
        return "redirect:/";
    }

    @PostMapping("/deleteSelected")
    public String deleteSelectedStudies(
            @RequestParam(value = "selectedIds", required = false) List<Integer> selectedIds,
            RedirectAttributes redirectAttributes) {
        System.out.println(selectedIds);
        if (selectedIds == null || selectedIds.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "No studies selected for deletion.");
            return "redirect:/";
        }

        try {
            sServ.deleteSelectedStudies(selectedIds);
            redirectAttributes.addFlashAttribute("successMessage", "Selected studies deleted successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error during deletion.");
        }
        return "redirect:/";
    }

}