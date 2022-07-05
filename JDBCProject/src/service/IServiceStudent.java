package service;

import bll.entity.Student;
import bll.repository.IRepository;
import bll.repository.RepositoryStudent;

public class IServiceStudent implements IService<Student> {

	IRepository<Student> studentIRepository = new RepositoryStudent();
	RepositoryStudent studentRepo = new RepositoryStudent();

	@Override
	public void addItem(Student item) {

		studentIRepository.addItem(item);
	}

	@Override
	public void deleteItem(int id) {

		studentIRepository.deleteItem(id);
	}

	@Override
	public void updateItem(Student item) {
		studentIRepository.updateItem(item);
	}

	@Override
	public boolean getItemByID(int id) {

		studentIRepository.getItemByID(id);
		return false;

	}

	@Override
	public void getAllItem() {
		studentIRepository.getAllItem();

	}

	@Override
	public void displayAllItem() {
		studentRepo.showStudentList();

	}

	@Override
	public void displayUpdatedItems() {
		studentRepo.updateStudentList();

	}

}
