package service;

import bll.entity.Teacher;
import bll.repository.IRepository;
import bll.repository.RepositoryTeacher;

public class IServiceTeacher implements IService<Teacher> {

	// for methods implemented in teacherRepository via IRepository
	IRepository<Teacher> teacherIRepository = new RepositoryTeacher();

	// for extra methods implemented in teacherRepository,
	// those not defined in IRepository
	RepositoryTeacher teacherRepo = new RepositoryTeacher();

	@Override
	public void addItem(Teacher item) {
		teacherIRepository.addItem(item);
	}

	@Override
	public void deleteItem(int id) {
		teacherIRepository.deleteItem(id);
	}

	@Override
	public void updateItem(Teacher item) {
		teacherIRepository.updateItem(item);
	}

	@Override
	public boolean getItemByID(int id) {
		teacherIRepository.getItemByID(id);
		return false;
	}

	@Override
	public void getAllItem() {
		teacherIRepository.getAllItem();
	}

	@Override
	public void displayAllItem() {
		teacherRepo.showTeacherList();
	}

	@Override
	public void displayUpdatedItems() {
		teacherRepo.showUpdatedTeacherList();
	}

}
