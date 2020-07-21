package lk.suwasewana.asset.medicalPackage.entity.Enum;

public enum MedicalPackageStatus {

    OPEN("Open"),
    TEMCLOSED("Temporarily Closed"),
    CLOSED("Closed");

    private final String medicalPackageStatus;

    MedicalPackageStatus(String medicalPackageStatus) {
        this.medicalPackageStatus = medicalPackageStatus;
    }

    public String getMedicalPackageStatus() {
        return medicalPackageStatus;
    }
}
