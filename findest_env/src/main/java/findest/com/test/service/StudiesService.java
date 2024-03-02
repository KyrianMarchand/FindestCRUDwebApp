package findest.com.test.service;

import findest.com.test.entity.Studies;

import java.util.List;

public interface StudiesService {

    public List<Studies> listOfStudies();

    public Studies getStudies(Integer id);

    public void addStudies(String n);

    public void removeStudies(Integer id);

    public void updateStudiesName(int studyId, String newName);

    public void deleteSelectedStudies(List<Integer> selectedIds);
}
