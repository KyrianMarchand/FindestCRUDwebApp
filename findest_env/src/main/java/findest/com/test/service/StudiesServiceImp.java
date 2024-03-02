package findest.com.test.service;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Component;

import findest.com.test.dao.StudiesDAO;
import findest.com.test.entity.Studies;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Component
public class StudiesServiceImp implements StudiesService {

    @Autowired
    private StudiesDAO dDAO;

    public List<Studies> listOfStudies() {
        System.out.println("Research Studies list\n");
        List<Studies> ls = dDAO.findAll("name", "ASC");
        System.out.println("List is ok !\n");
        return ls;
    }

    public Studies getStudies(Integer id) {
        return dDAO.findById(id);
    }

    public void addStudies(String name) {
        Studies d = new Studies();
        d.setName(name);
        LocalDate currentDate = LocalDate.now();
        d.setCreationDate(currentDate);
        dDAO.create(d);
    }

    public void removeStudies(Integer id) {
        dDAO.remove(dDAO.findById(id));
    }

    @Transactional
    public void updateStudiesName(int studyId, String newName) {
        Studies study = dDAO.findById(studyId);
        study.setName(newName);
        dDAO.update(study);
    }

    public void deleteSelectedStudies(List<Integer> selectedIds) {
        // Check if the list is null or empty before proceeding
        if (selectedIds == null || selectedIds.isEmpty()) {
            System.out.println("No studies selected for deletion.");
            return; // Exit the method early if there are no IDs to process
        }

        for (Integer id : selectedIds) {
            try {
                removeStudies(id); // Assuming removeStudies is your existing method to delete a study by ID
            } catch (Exception e) {
                System.out.println("Error deleting study with ID: " + id + " - " + e.getMessage());
                // Handle exception or log error as needed
            }
        }
    }

}
