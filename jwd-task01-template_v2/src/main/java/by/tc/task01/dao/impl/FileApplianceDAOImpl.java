package by.tc.task01.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

public class FileApplianceDAOImpl implements ApplianceDAO {

	private static final String FILE_NAME = "appliances_db.txt";

	@Override
	public List<Appliance> find(Criteria criteria) throws DAOException {

		List<Appliance> findList = new ArrayList<Appliance>();

		List<String> requirements = getRequirement(criteria);
		List<String> lineForCreateObjects = new ArrayList<String>();

		ClassLoader loader = FileApplianceDAOImpl.class.getClassLoader();
		File file = new File(loader.getResource(FILE_NAME).getFile());

		Scanner sc = null;
		try {
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				if (criteria.getGroupSearchName() == null) {
					criteria.setGroupSearchName("");
				}

				if (line.toLowerCase().contains(criteria.getGroupSearchName().toLowerCase())) {

					if (isMatch(line, requirements)) {
						lineForCreateObjects.add(line);
					}
				}

				findList = createAppliances(lineForCreateObjects);

			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		return findList;
	}

	private List<String> getRequirement(Criteria criteria) {

		List<String> requirements = new ArrayList<String>();

		for (Map.Entry<String, Object> entry : criteria.getCriteria().entrySet()) {

			StringBuilder requirement = new StringBuilder();
			requirement.append(entry.getKey()).append("=").append(entry.getValue().toString());

			requirements.add(requirement.toString());
		}
		return requirements;
	}

	private boolean isMatch(String line, List<String> requirements) {

		boolean isContains = false;

		if (requirements.size() == 0) {
			isContains = true;
		} else {
			String[] paramsToCompare = line.split("[,]*[\\s:]+");
//			System.out.println("size!=0");

			int count = 0;
			for (String requirement : requirements) {
				for (String param : paramsToCompare) {
					if (requirement.equals(param)) {
						count++;
					}
				}
			}

			if (count == requirements.size()) {
				isContains = true;
			}
		}
		return isContains;
	}

	private List<Appliance> createAppliances(List<String> lineForCreateObjects) {

		List<Appliance> appliances = new ArrayList<Appliance>();

		for (String line : lineForCreateObjects) {
			String[] dataArrayOfLine = line.split("[,]*[\\s=:]+");

			switch (dataArrayOfLine[0].toLowerCase()) {
			case "oven":
				appliances.add(initializationOven(dataArrayOfLine));
				break;
			case "refrigerator":
				appliances.add(initializationRefrigerator(dataArrayOfLine));
				break;
			case "vacuumcleaner":
				appliances.add(initializationVacuumCleaner(dataArrayOfLine));
				break;
			case "laptop":
				appliances.add(initializationLaptop(dataArrayOfLine));
				break;
			case "speakers":
				appliances.add(initializationSpeakers(dataArrayOfLine));
				break;
			case "tabletpc":
				appliances.add(initializationTabletPC(dataArrayOfLine));
				break;
			}
		}

		return appliances;

	}

	private Appliance initializationOven(String[] dataArrayOfLine) {
		Oven app = new Oven();

		for (int i = 0; i < dataArrayOfLine.length; i++) {

			if (dataArrayOfLine[i].equals(SearchCriteria.Oven.POWER_CONSUMPTION.toString())) {
				app.setPowerConsuption(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Oven.WEIGHT.toString())) {
				app.setWeight(Double.parseDouble(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Oven.CAPACITY.toString())) {
				app.setCapacity(Double.parseDouble(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Oven.DEPTH.toString())) {
				app.setDepth(Double.parseDouble(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Oven.HEIGHT.toString())) {
				app.setHeight(Double.parseDouble(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Oven.WIDTH.toString())) {
				app.setWidth(Double.parseDouble(dataArrayOfLine[i + 1]));
			}
		}
		return app;
	}

	private Appliance initializationRefrigerator(String[] dataArrayOfLine) {
		Refrigerator app = new Refrigerator();

		for (int i = 0; i < dataArrayOfLine.length; i++) {

			if (dataArrayOfLine[i].equals(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())) {
				app.setPowerConsuption(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Refrigerator.WEIGHT.toString())) {
				app.setWeight(Double.parseDouble(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString())) {
				app.setFreezerCapacity(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString())) {
				app.setOveralCapacity(Double.parseDouble(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Refrigerator.HEIGHT.toString())) {
				app.setHeight(Double.parseDouble(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Refrigerator.WIDTH.toString())) {
				app.setWidth(Double.parseDouble(dataArrayOfLine[i + 1]));
			}
		}
		return app;
	}

	private Appliance initializationVacuumCleaner(String[] dataArrayOfLine) {
		VacuumCleaner app = new VacuumCleaner();

		for (int i = 0; i < dataArrayOfLine.length; i++) {

			if (dataArrayOfLine[i].equals(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())) {
				app.setPowerConsuption(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString())) {
				app.setFilterType(dataArrayOfLine[i + 1]);
			} else if (dataArrayOfLine[i].equals(SearchCriteria.VacuumCleaner.BAG_TYPE.toString())) {
				app.setBagType(dataArrayOfLine[i + 1]);
			} else if (dataArrayOfLine[i].equals(SearchCriteria.VacuumCleaner.WAND_TYPE.toString())) {
				app.setWandType(dataArrayOfLine[i + 1]);
			} else if (dataArrayOfLine[i].equals(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString())) {
				app.setMotorSpeedRegulation(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())) {
				app.setCleaningWidth(Integer.parseInt(dataArrayOfLine[i + 1]));
			}
		}
		return app;
	}

	private Appliance initializationLaptop(String[] dataArrayOfLine) {
		Laptop app = new Laptop();

		for (int i = 0; i < dataArrayOfLine.length; i++) {

			if (dataArrayOfLine[i].equals(SearchCriteria.Laptop.BATTERY_CAPACITY.toString())) {
				app.setBatteryCapacity(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Laptop.OS.toString())) {
				app.setOperatingSystem(dataArrayOfLine[i + 1]);
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Laptop.MEMORY_ROM.toString())) {
				app.setMemoryRom(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Laptop.SYSTEM_MEMORY.toString())) {
				app.setSystemMemory(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Laptop.CPU.toString())) {
				app.setCpu(Double.parseDouble(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Laptop.DISPLAY_INCHS.toString())) {
				app.setDisplayInches(Double.parseDouble(dataArrayOfLine[i + 1]));
			}
		}
		return app;
	}

	private Appliance initializationSpeakers(String[] dataArrayOfLine) {
		Speakers app = new Speakers();

		for (int i = 0; i < dataArrayOfLine.length; i++) {

			if (dataArrayOfLine[i].equals(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())) {
				app.setPowerConsuption(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString())) {
				app.setNumberOfSpeakers(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Speakers.FREQUENCY_RANGE.toString())) {
				app.setFreqencyRange(dataArrayOfLine[i + 1]);
			} else if (dataArrayOfLine[i].equals(SearchCriteria.Speakers.CORD_LENGTH.toString())) {
				app.setCordLength(Double.parseDouble(dataArrayOfLine[i + 1]));
			}
		}
		return app;
	}

	private Appliance initializationTabletPC(String[] dataArrayOfLine) {
		TabletPC app = new TabletPC();

		for (int i = 0; i < dataArrayOfLine.length; i++) {

			if (dataArrayOfLine[i].equals(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())) {
				app.setBatteryCapacity(Double.parseDouble(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.TabletPC.DISPLAY_INCHES.toString())) {
				app.setDisplayInches(Double.parseDouble(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.TabletPC.MEMORY_ROM.toString())) {
				app.setMemoryRom(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString())) {
				app.setFlashMemoryCapacity(Integer.parseInt(dataArrayOfLine[i + 1]));
			} else if (dataArrayOfLine[i].equals(SearchCriteria.TabletPC.COLOR.toString())) {
				app.setColor(dataArrayOfLine[i + 1]);
			}
		}
		return app;
	}

}
