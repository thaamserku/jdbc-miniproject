package service;

import bll.entity.Staff;
import bll.repository.IRepository;
import bll.repository.RepositoryStaff;

public class IServiceStaff implements IService<Staff> {

	IRepository<Staff> staffIRepository = new RepositoryStaff();
	RepositoryStaff staffRepo = new RepositoryStaff();

	@Override
	public void addItem(Staff item) {
		staffIRepository.addItem(item);
	}

	@Override
	public void deleteItem(int id) {
		staffIRepository.deleteItem(id);
	}

	@Override
	public void updateItem(Staff item) {
		staffIRepository.updateItem(item);

	}

	@Override
	public boolean getItemByID(int id) {
		staffIRepository.getItemByID(id);
		return false;
	}

	@Override
	public void getAllItem() {
		staffIRepository.getAllItem();
	}

	@Override
	public void displayAllItem() {
		staffRepo.displayStaffList();
	}

	@Override
	public void displayUpdatedItems() {
		staffRepo.displayUpdatedStaffList();
	}

}
