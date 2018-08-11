package by.epam.domain.specialization;

import java.util.List;

import by.epam.domain.subtypespecialization.BeautyAndHealth;
import by.epam.domain.subtypespecialization.CleaningAndHelp;
import by.epam.domain.subtypespecialization.ComputerHelp;
import by.epam.domain.subtypespecialization.CourierService;
import by.epam.domain.subtypespecialization.Design;
import by.epam.domain.subtypespecialization.Education;
import by.epam.domain.subtypespecialization.EventAndPromotion;
import by.epam.domain.subtypespecialization.InstallAndRepairEquipment;
import by.epam.domain.subtypespecialization.LegalAssistance;
import by.epam.domain.subtypespecialization.PhotoAndVideoService;
import by.epam.domain.subtypespecialization.RepairAndConstruction;
import by.epam.domain.subtypespecialization.RepairTransport;
import by.epam.domain.subtypespecialization.TruckingIndustry;
import by.epam.domain.subtypespecialization.WebDeveloping;
import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class Specialization {
	
	private final String activities;
	private final String description;
	private final List<String> subspecialization;
	private final BeautyAndHealth beautyAndHealth;
	private final CleaningAndHelp cleaningAndHelp;
	private final ComputerHelp computerHelp;
	private final CourierService courierService;
	private final Design design;
	private final Education education;
	private final EventAndPromotion eventAndPromotion;
	private final InstallAndRepairEquipment installAndRepairEquipment;
	private final LegalAssistance legalAssistance;
	private final PhotoAndVideoService photoAndVideoService;
	private final RepairAndConstruction repairAndConstruction;
	private final RepairTransport repairTransport;
	private final TruckingIndustry truckingIndustry;
	private final WebDeveloping webDeveloping;
	
	public String getActivities() {
		return activities;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getSubspecialization() {
		return subspecialization;
	}

	public BeautyAndHealth getBeautyAndHealth() {
		return beautyAndHealth;
	}

	public CleaningAndHelp getCleaningAndHelp() {
		return cleaningAndHelp;
	}

	public ComputerHelp getComputerHelp() {
		return computerHelp;
	}

	public CourierService getCourierService() {
		return courierService;
	}

	public Design getDesign() {
		return design;
	}

	public Education getEducation() {
		return education;
	}

	public EventAndPromotion getEventAndPromotion() {
		return eventAndPromotion;
	}

	public InstallAndRepairEquipment getInstallAndRepairEquipment() {
		return installAndRepairEquipment;
	}

	public LegalAssistance getLegalAssistance() {
		return legalAssistance;
	}

	public PhotoAndVideoService getPhotoAndVideoService() {
		return photoAndVideoService;
	}

	public RepairAndConstruction getRepairAndConstruction() {
		return repairAndConstruction;
	}

	public RepairTransport getRepairTransport() {
		return repairTransport;
	}

	public TruckingIndustry getTruckingIndustry() {
		return truckingIndustry;
	}

	public WebDeveloping getWebDeveloping() {
		return webDeveloping;
	}

	private Specialization(Builder builder) {
		this.activities = builder.activities;
		this.description = builder.description;
		this.subspecialization = builder.subspecialization;
		this.beautyAndHealth = builder.beautyAndHealth;
		this.cleaningAndHelp = builder.cleaningAndHelp;
		this.computerHelp = builder.computerHelp;
		this.courierService = builder.courierService;
		this.design = builder.design;
		this.education = builder.education;
		this.eventAndPromotion = builder.eventAndPromotion;
		this.installAndRepairEquipment = builder.installAndRepairEquipment;
		this.legalAssistance = builder.legalAssistance;
		this.photoAndVideoService = builder.photoAndVideoService;
		this.repairAndConstruction = builder.repairAndConstruction;
		this.repairTransport = builder.repairTransport;
		this.truckingIndustry = builder.truckingIndustry;
		this.webDeveloping = builder.webDeveloping;
	}

	public static class Builder {
		private String activities;
		private String description;
		private List<String> subspecialization;
		private BeautyAndHealth beautyAndHealth;
		private CleaningAndHelp cleaningAndHelp;
		private ComputerHelp computerHelp;
		private CourierService courierService;
		private Design design;
		private Education education;
		private EventAndPromotion eventAndPromotion;
		private InstallAndRepairEquipment installAndRepairEquipment;
		private LegalAssistance legalAssistance;
		private PhotoAndVideoService photoAndVideoService;
		private RepairAndConstruction repairAndConstruction;
		private RepairTransport repairTransport;
		private TruckingIndustry truckingIndustry;
		private WebDeveloping webDeveloping;
		
		public Builder setActivities(String activities) {
			this.activities = activities;
			return this;
		}
		
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setSubspecialization(List<String> subspecialization) {
			this.subspecialization = subspecialization;
			return this;
		}

		public Builder setBeautyAndHealth(BeautyAndHealth beautyAndHealth) {
			this.beautyAndHealth = beautyAndHealth;
			return this;
		}
		public Builder setCleaningAndHelp(CleaningAndHelp cleaningAndHelp) {
			this.cleaningAndHelp = cleaningAndHelp;
			return this;
		}
		public Builder setComputerHelp(ComputerHelp computerHelp) {
			this.computerHelp = computerHelp;
			return this;
		}
		public Builder setCourierService(CourierService courierService) {
			this.courierService = courierService;
			return this;
		}
		public Builder setDesign(Design design) {
			this.design = design;
			return this;
		}
		public Builder setEducation(Education education) {
			this.education = education;
			return this;
		}
		public Builder setEventAndPromotion(EventAndPromotion eventAndPromotion) {
			this.eventAndPromotion = eventAndPromotion;
			return this;
		}
		public Builder setInstallAndRepairEquipment(InstallAndRepairEquipment installAndRepairEquipment) {
			this.installAndRepairEquipment = installAndRepairEquipment;
			return this;
		}
		public Builder setLegalAssistance(LegalAssistance legalAssistance) {
			this.legalAssistance = legalAssistance;
			return this;
		}
		public Builder setPhotoAndVideoService(PhotoAndVideoService photoAndVideoService) {
			this.photoAndVideoService = photoAndVideoService;
			return this;
		}
		public Builder setRepairAndConstruction(RepairAndConstruction repairAndConstruction) {
			this.repairAndConstruction = repairAndConstruction;
			return this;
		}
		public Builder setRepairTransport(RepairTransport repairTransport) {
			this.repairTransport = repairTransport;
			return this;
		}
		public Builder setTruckingIndustry(TruckingIndustry truckingIndustry) {
			this.truckingIndustry = truckingIndustry;
			return this;
		}
		public Builder setWebDeveloping(WebDeveloping webDeveloping) {
			this.webDeveloping = webDeveloping;
			return this;
		}
		
		public Specialization build() {
			return new Specialization(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activities == null) ? 0 : activities.hashCode());
		result = prime * result + ((beautyAndHealth == null) ? 0 : beautyAndHealth.hashCode());
		result = prime * result + ((cleaningAndHelp == null) ? 0 : cleaningAndHelp.hashCode());
		result = prime * result + ((computerHelp == null) ? 0 : computerHelp.hashCode());
		result = prime * result + ((courierService == null) ? 0 : courierService.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((design == null) ? 0 : design.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((eventAndPromotion == null) ? 0 : eventAndPromotion.hashCode());
		result = prime * result + ((installAndRepairEquipment == null) ? 0 : installAndRepairEquipment.hashCode());
		result = prime * result + ((legalAssistance == null) ? 0 : legalAssistance.hashCode());
		result = prime * result + ((photoAndVideoService == null) ? 0 : photoAndVideoService.hashCode());
		result = prime * result + ((repairAndConstruction == null) ? 0 : repairAndConstruction.hashCode());
		result = prime * result + ((repairTransport == null) ? 0 : repairTransport.hashCode());
		result = prime * result + ((truckingIndustry == null) ? 0 : truckingIndustry.hashCode());
		result = prime * result + ((webDeveloping == null) ? 0 : webDeveloping.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Specialization other = (Specialization) obj;
		if (activities == null) {
			if (other.activities != null)
				return false;
		} else if (!activities.equals(other.activities))
			return false;
		if (beautyAndHealth == null) {
			if (other.beautyAndHealth != null)
				return false;
		} else if (!beautyAndHealth.equals(other.beautyAndHealth))
			return false;
		if (cleaningAndHelp == null) {
			if (other.cleaningAndHelp != null)
				return false;
		} else if (!cleaningAndHelp.equals(other.cleaningAndHelp))
			return false;
		if (computerHelp == null) {
			if (other.computerHelp != null)
				return false;
		} else if (!computerHelp.equals(other.computerHelp))
			return false;
		if (courierService == null) {
			if (other.courierService != null)
				return false;
		} else if (!courierService.equals(other.courierService))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (design == null) {
			if (other.design != null)
				return false;
		} else if (!design.equals(other.design))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (eventAndPromotion == null) {
			if (other.eventAndPromotion != null)
				return false;
		} else if (!eventAndPromotion.equals(other.eventAndPromotion))
			return false;
		if (installAndRepairEquipment == null) {
			if (other.installAndRepairEquipment != null)
				return false;
		} else if (!installAndRepairEquipment.equals(other.installAndRepairEquipment))
			return false;
		if (legalAssistance == null) {
			if (other.legalAssistance != null)
				return false;
		} else if (!legalAssistance.equals(other.legalAssistance))
			return false;
		if (photoAndVideoService == null) {
			if (other.photoAndVideoService != null)
				return false;
		} else if (!photoAndVideoService.equals(other.photoAndVideoService))
			return false;
		if (repairAndConstruction == null) {
			if (other.repairAndConstruction != null)
				return false;
		} else if (!repairAndConstruction.equals(other.repairAndConstruction))
			return false;
		if (repairTransport == null) {
			if (other.repairTransport != null)
				return false;
		} else if (!repairTransport.equals(other.repairTransport))
			return false;
		if (truckingIndustry == null) {
			if (other.truckingIndustry != null)
				return false;
		} else if (!truckingIndustry.equals(other.truckingIndustry))
			return false;
		if (webDeveloping == null) {
			if (other.webDeveloping != null)
				return false;
		} else if (!webDeveloping.equals(other.webDeveloping))
			return false;
		return true;
	}
	
}
