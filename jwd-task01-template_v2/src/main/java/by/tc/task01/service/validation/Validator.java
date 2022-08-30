package by.tc.task01.service.validation;

import java.util.Map;

import by.tc.task01.entity.criteria.Criteria;

public class Validator {

	public static boolean criteriaValidator(Criteria criteria) {

		boolean isValid = false;

		String criteriaName = criteria.getGroupSearchName();

		if (criteriaName == null) {
			criteriaName = "";
		} else {
			criteriaName = criteriaName.toLowerCase();
		}
		switch (criteriaName) {
		case "oven":
			isValid = revisionOven(criteria);
			break;
		case "refrigerator":
			isValid = revisionRefrigerator(criteria);
			break;
		case "vacuumcleaner":
			isValid = revisionVacuumCleaner(criteria);
			break;
		case "laptop":
			isValid = revisionLaptop(criteria);
			break;
		case "tabletpc":
			isValid = revisionTabletPC(criteria);
			break;
		case "speakers":
			isValid = revisionSpeakers(criteria);
			break;
		case "":
			isValid = revisionWithoutName(criteria);
			break;
		}

		// you may add your own code here

		return isValid;
	}

	private static boolean revisionOven(Criteria criteria) {

		boolean isValid = true;

		for (Map.Entry<String, Object> entryCriteria : criteria.getCriteria().entrySet()) {

			String itemSpecifics = entryCriteria.getKey().toString();
			Object valueItemSpecifics = entryCriteria.getValue();

//			if (isPowerConsuption(itemSpecifics)) {
//				if (!isInteger(valueItemSpecifics)) {
//					return !isValid;//////////////////////////////////// можно так?
//				}
//			}		

			if (isPowerConsuption(itemSpecifics)) {
				if (isInteger(valueItemSpecifics.getClass())) {
					int value = Integer.valueOf(valueItemSpecifics.toString());
					if (value < 0 && value > 10000) {
						isValid = false;
						break;
					}
				}
			}

			if (isWeight(itemSpecifics)) {
				if (isDouble(valueItemSpecifics.getClass())) {
					double value = Double.valueOf(valueItemSpecifics.toString());
					if (value < 0 && value > 100.0) {
						isValid = false;
						break;
					}
				}
			}

			if (isCapacity(itemSpecifics)) {
				if (isDouble(valueItemSpecifics.getClass())) {
					double value = Double.valueOf(valueItemSpecifics.toString());
					if (value < 0 && value > 100.0) {
						isValid = false;
						break;
					}
				}
			}

			if (isDepth(itemSpecifics)) {
				if (isDouble(valueItemSpecifics.getClass())) {
					double value = Double.valueOf(valueItemSpecifics.toString());
					if (value < 0 && value > 80.0) {
						isValid = false;
						break;
					}
				}
			}

			if (isHeight(itemSpecifics)) {
				if (isDouble(valueItemSpecifics.getClass())) {
					double value = Double.valueOf(valueItemSpecifics.toString());
					if (value < 0 && value > 70.0) {
						isValid = false;
						break;
					}
				}
			}

			if (isWidth(itemSpecifics)) {
				if (isDouble(valueItemSpecifics.getClass())) {
					double value = Double.valueOf(valueItemSpecifics.toString());
					if (value < 0 && value > 70.0) {
						isValid = false;
						break;
					}
				}
			}

		}
		return isValid;
	}

	private static boolean revisionRefrigerator(Criteria criteria) {

		boolean isValid = true;

		for (Map.Entry<String, Object> entryCriteria : criteria.getCriteria().entrySet()) {

			String itemSpecifics = entryCriteria.getKey().toString();
			Object valueItemSpecifics = entryCriteria.getValue().getClass();

			if (isPowerConsuption(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isWeight(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isFreezerCapacity(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isOveralCapacity(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isHeight(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isWidth(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

		}
		return isValid;
	}

	private static boolean revisionVacuumCleaner(Criteria criteria) {

		boolean isValid = true;

		for (Map.Entry<String, Object> entryCriteria : criteria.getCriteria().entrySet()) {

			String itemSpecifics = entryCriteria.getKey().toString();
			Object valueItemSpecifics = entryCriteria.getValue().getClass();

			if (isPowerConsuption(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isFilterType(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isBagType(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isWandType(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isMotorSpeesRegulation(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isCleaningWidth(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}
		}
		return isValid;
	}

	private static boolean revisionLaptop(Criteria criteria) {

		boolean isValid = true;

		for (Map.Entry<String, Object> entryCriteria : criteria.getCriteria().entrySet()) {

			String itemSpecifics = entryCriteria.getKey().toString();
			Object valueItemSpecifics = entryCriteria.getValue().getClass();

			if (isBatteryCapacity(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isOS(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isMemoryROM(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isSystemMemory(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isCPU(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isDisplayInchs(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

		}
		return isValid;
	}

	private static boolean revisionTabletPC(Criteria criteria) {

		boolean isValid = true;

		for (Map.Entry<String, Object> entryCriteria : criteria.getCriteria().entrySet()) {

			String itemSpecifics = entryCriteria.getKey().toString();
			Object valueItemSpecifics = entryCriteria.getValue().getClass();

			if (isBatteryCapacity(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isDisplayInchs(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isMemoryROM(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isFlashMemotyCapacity(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isColor(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}
		}
		return isValid;
	}

	private static boolean revisionSpeakers(Criteria criteria) {

		boolean isValid = true;

		for (Map.Entry<String, Object> entryCriteria : criteria.getCriteria().entrySet()) {

			String itemSpecifics = entryCriteria.getKey().toString();
			Object valueItemSpecifics = entryCriteria.getValue().getClass();

			if (isPowerConsuption(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isNumberOfSpeakers(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isFrequencyRange(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isCordLength(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}
		}

		return isValid;
	}

	private static boolean revisionWithoutName(Criteria criteria) {

		boolean isValid = true;

		for (Map.Entry<String, Object> entryCriteria : criteria.getCriteria().entrySet()) {

			String itemSpecifics = entryCriteria.getKey().toString();
			Object valueItemSpecifics = entryCriteria.getValue().getClass();

			if (isPowerConsuption(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isWeight(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isCapacity(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isDepth(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isHeight(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isFreezerCapacity(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isOveralCapacity(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isFilterType(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isBagType(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isWandType(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isMotorSpeesRegulation(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isCleaningWidth(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isBatteryCapacity(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isOS(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isMemoryROM(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isSystemMemory(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isCPU(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isDisplayInchs(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isFlashMemotyCapacity(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isColor(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isNumberOfSpeakers(itemSpecifics)) {
				if (!isInteger(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isFrequencyRange(itemSpecifics)) {
				if (!isCorrectString(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}

			if (isCordLength(itemSpecifics)) {
				if (!isDouble(valueItemSpecifics)) {
					isValid = false;
					break;
				}
			}
		}
		return isValid;
	}
//////////////////////////// Такой метод можно написать для всех объектов?

//	private static boolean isPowerConsuption(String itemSpecifics, Object valueItemSpecifics) {
//		if (itemSpecifics.equals("POWER_CONSUMPTION")) {
//			if (isInteger(valueItemSpecifics.getClass())) {
//				int valueToInteger = Integer.valueOf((Integer) valueItemSpecifics);
//				if (valueToInteger > 0 && valueToInteger < 10000) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}

	private static boolean isPowerConsuption(String itemSpecifics) {
		return itemSpecifics.equals("POWER_CONSUMPTION");
	}

	private static boolean isWeight(String itemSpecifics) {
		return itemSpecifics.equals("WEIGHT");
	}

	private static boolean isCapacity(String itemSpecifics) {
		return itemSpecifics.equals("CAPACITY");
	}

	private static boolean isDepth(String itemSpecifics) {
		return itemSpecifics.equals("DEPTH");
	}

	private static boolean isHeight(String itemSpecifics) {
		return itemSpecifics.equals("HEIGHT");
	}

	private static boolean isWidth(String itemSpecifics) {
		return itemSpecifics.equals("WIDTH");
	}

	private static boolean isFreezerCapacity(String itemSpecifics) {
		return itemSpecifics.equals("FREEZER_CAPACITY");
	}

	private static boolean isOveralCapacity(String itemSpecifics) {
		return itemSpecifics.equals("OVERALL_CAPACITY");
	}

	private static boolean isFilterType(String itemSpecifics) {
		return itemSpecifics.equals("FILTER_TYPE");
	}

	private static boolean isBagType(String itemSpecifics) {
		return itemSpecifics.equals("BAG_TYPE");
	}

	private static boolean isWandType(String itemSpecifics) {
		return itemSpecifics.equals("WAND_TYPE");
	}

	private static boolean isMotorSpeesRegulation(String itemSpecifics) {
		return itemSpecifics.equals("MOTOR_SPEED_REGULATION");
	}

	private static boolean isCleaningWidth(String itemSpecifics) {
		return itemSpecifics.equals("CLEANING_WIDTH");
	}

	private static boolean isBatteryCapacity(String itemSpecifics) {
		return itemSpecifics.equals("BATTERY_CAPACITY");
	}

	private static boolean isOS(String itemSpecifics) {
		return itemSpecifics.equals("OS");
	}

	private static boolean isMemoryROM(String itemSpecifics) {
		return itemSpecifics.equals("MEMORY_ROM");
	}

	private static boolean isSystemMemory(String itemSpecifics) {
		return itemSpecifics.equals("SYSTEM_MEMORY");
	}

	private static boolean isCPU(String itemSpecifics) {
		return itemSpecifics.equals("CPU");
	}

	private static boolean isDisplayInchs(String itemSpecifics) {
		return itemSpecifics.equals("DISPLAY_INCHS");
	}

	private static boolean isFlashMemotyCapacity(String itemSpecifics) {
		return itemSpecifics.equals("FLASH_MEMORY_CAPACITY");
	}

	private static boolean isColor(String itemSpecifics) {
		return itemSpecifics.equals("COLOR");
	}

	private static boolean isNumberOfSpeakers(String itemSpecifics) {
		return itemSpecifics.equals("NUMBER_OF_SPEAKERS");
	}

	private static boolean isFrequencyRange(String itemSpecifics) {
		return itemSpecifics.equals("FREQUENCY_RANGE");
	}

	private static boolean isCordLength(String itemSpecifics) {
		return itemSpecifics.equals("CORD_LENGTH");
	}

	private static boolean isDouble(Object object) {
		return object == Double.class || object == Integer.class;
	}

	private static boolean isInteger(Object object) {
		return object == Integer.class;
	}

	private static boolean isCorrectString(Object object) {
		return object == String.class && !object.toString().equals("");
	}

}

//you may add your own new classes