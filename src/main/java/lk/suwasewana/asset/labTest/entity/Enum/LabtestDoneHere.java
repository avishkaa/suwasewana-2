package lk.suwasewana.asset.labTest.entity.Enum;

public enum LabtestDoneHere {
    YES("Done Here"),
    NO("No");

    private final String labtestDoneHere;

    LabtestDoneHere(String labtestDoneHere) {
        this.labtestDoneHere = labtestDoneHere;
    }

    public String getLabtestDoneHere() {
        return labtestDoneHere;
    }
}

