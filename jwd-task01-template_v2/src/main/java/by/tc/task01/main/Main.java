package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import java.util.List;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) throws ServiceException {
		List<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());
//		criteriaOven.add(Oven.CAPACITY.toString(), 3);
//		criteriaOven.add(Oven.WEIGHT.toString(), 11);
//		criteriaOven.add(Oven.CAPACITY.toString(), 33);
//		criteriaOven.add(Oven.WIDTH.toString(), 68);
//		criteriaOven.add(Oven.HEIGHT.toString(), 40);
//		criteriaOven.add(Oven.DEPTH.toString(), 60);
//		criteriaOven.add(Oven.POWER_CONSUMPTION.toString(), 2000);

		appliances = service.find(criteriaOven);

		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

//		Criteria criteriaVacuumCleaner = new Criteria(VacuumCleaner.class.getSimpleName());
//		criteriaVacuumCleaner.add(VacuumCleaner.BAG_TYPE.toString(), "a2");
//		criteriaVacuumCleaner.add(VacuumCleaner.BAG_TYPE.toString(), "a2");
//		criteriaVacuumCleaner.add(VacuumCleaner.WAND_TYPE.toString(), "all-in-onE");

//		appliances = service.find(criteriaVacuumCleaner);
//
//		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

//		Criteria criteriaLaptop = new Criteria(Laptop.class.getSimpleName());
//		criteriaLaptop.add(Laptop.OS.toString(), "a2");
//		criteriaLaptop.add(Laptop.BATTERY_CAPACITY.toString(), 3);
//
//		appliances = service.find(criteriaLaptop);
//
//		PrintApplianceInfo.print(appliances);

//		Criteria criteriaLaptop = new Criteria(Laptop.class.getSimpleName());
////		criteriaLaptop.add(Laptop.OS.toString(), "win");
//		criteriaLaptop.add(Laptop.BATTERY_CAPACITY.toString(), 2);
////
//		appliances = service.find(criteriaLaptop);
////
//		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

//		criteriaOven = new Criteria(Oven.class.getSimpleName());
//		criteriaOven.add(Oven.HEIGHT.toString(), 200);
//		criteriaOven.add(Oven.DEPTH.toString(), 300);
//		criteriaOven.add(Oven.HEIGHT.toString(), 45);
//
//		appliances = service.find(criteriaOven);
//
//		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

//		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
//		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
//		criteriaTabletPC.add(TabletPC.BATTERY_CAPACITY.toString(), 3);
//		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);
//
//		appliances = service.find(criteriaTabletPC);// find(Object...obj)
//
//		PrintApplianceInfo.print(appliances);

		///////////////////////////////////////////////////////////////

//		Criteria criteriaSpeakers = new Criteria(Speakers.class.getSimpleName());
////		criteriaSpeakers.add(TabletPC.COLOR.toString(), "BLUE");
//		criteriaSpeakers.add(Speakers.NUMBER_OF_SPEAKERS.toString(), 3);
//		criteriaSpeakers.add(Speakers.POWER_CONSUMPTION.toString(), 20);
//
//		appliances = service.find(criteriaSpeakers);// find(Object...obj)
//
//		PrintApplianceInfo.print(appliances);

		///////////////////////////////////////////////////////////////
		Criteria criteriaApp = new Criteria();
		criteriaApp.add("POWER_CONSUMPTION", 100);
//		criteriaApp.add("COLOR", "blue");
		criteriaApp.add("WIDTH", 70);

		appliances = service.find(criteriaApp);
		PrintApplianceInfo.print(appliances);

	}

}
