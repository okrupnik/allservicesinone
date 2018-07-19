package by.epam.domain.specialization;

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

public class Specialization {
	
	private String activities;
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
	
	public Specialization() {
		
	}

	public Specialization(String activities, BeautyAndHealth beautyAndHealth, CleaningAndHelp cleaningAndHelp,
			ComputerHelp computerHelp, CourierService courierService, Design design, Education education,
			EventAndPromotion eventAndPromotion, InstallAndRepairEquipment installAndRepairEquipment,
			LegalAssistance legalAssistance, PhotoAndVideoService photoAndVideoService,
			RepairAndConstruction repairAndConstruction, RepairTransport repairTransport,
			TruckingIndustry truckingIndustry, WebDeveloping webDeveloping) {
		this.activities = activities;
		this.beautyAndHealth = beautyAndHealth;
		this.cleaningAndHelp = cleaningAndHelp;
		this.computerHelp = computerHelp;
		this.courierService = courierService;
		this.design = design;
		this.education = education;
		this.eventAndPromotion = eventAndPromotion;
		this.installAndRepairEquipment = installAndRepairEquipment;
		this.legalAssistance = legalAssistance;
		this.photoAndVideoService = photoAndVideoService;
		this.repairAndConstruction = repairAndConstruction;
		this.repairTransport = repairTransport;
		this.truckingIndustry = truckingIndustry;
		this.webDeveloping = webDeveloping;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	public BeautyAndHealth getBeautyAndHealth() {
		return beautyAndHealth;
	}

	public void setBeautyAndHealth(BeautyAndHealth beautyAndHealth) {
		this.beautyAndHealth = beautyAndHealth;
	}

	public CleaningAndHelp getCleaningAndHelp() {
		return cleaningAndHelp;
	}

	public void setCleaningAndHelp(CleaningAndHelp cleaningAndHelp) {
		this.cleaningAndHelp = cleaningAndHelp;
	}

	public ComputerHelp getComputerHelp() {
		return computerHelp;
	}

	public void setComputerHelp(ComputerHelp computerHelp) {
		this.computerHelp = computerHelp;
	}

	public CourierService getCourierService() {
		return courierService;
	}

	public void setCourierService(CourierService courierService) {
		this.courierService = courierService;
	}

	public Design getDesign() {
		return design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public EventAndPromotion getEventAndPromotion() {
		return eventAndPromotion;
	}

	public void setEventAndPromotion(EventAndPromotion eventAndPromotion) {
		this.eventAndPromotion = eventAndPromotion;
	}

	public InstallAndRepairEquipment getInstallAndRepairEquipment() {
		return installAndRepairEquipment;
	}

	public void setInstallAndRepairEquipment(InstallAndRepairEquipment installAndRepairEquipment) {
		this.installAndRepairEquipment = installAndRepairEquipment;
	}

	public LegalAssistance getLegalAssistance() {
		return legalAssistance;
	}

	public void setLegalAssistance(LegalAssistance legalAssistance) {
		this.legalAssistance = legalAssistance;
	}

	public PhotoAndVideoService getPhotoAndVideoService() {
		return photoAndVideoService;
	}

	public void setPhotoAndVideoService(PhotoAndVideoService photoAndVideoService) {
		this.photoAndVideoService = photoAndVideoService;
	}

	public RepairAndConstruction getRepairAndConstruction() {
		return repairAndConstruction;
	}

	public void setRepairAndConstruction(RepairAndConstruction repairAndConstruction) {
		this.repairAndConstruction = repairAndConstruction;
	}

	public RepairTransport getRepairTransport() {
		return repairTransport;
	}

	public void setRepairTransport(RepairTransport repairTransport) {
		this.repairTransport = repairTransport;
	}

	public TruckingIndustry getTruckingIndustry() {
		return truckingIndustry;
	}

	public void setTruckingIndustry(TruckingIndustry truckingIndustry) {
		this.truckingIndustry = truckingIndustry;
	}

	public WebDeveloping getWebDeveloping() {
		return webDeveloping;
	}

	public void setWebDeveloping(WebDeveloping webDeveloping) {
		this.webDeveloping = webDeveloping;
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
