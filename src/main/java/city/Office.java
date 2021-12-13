package city;

public class Office extends Building {
    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
        super(area, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    public Office(int area, int levels, Address address,String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        calculateTableSpace();
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return numberOfTablesPerLevel * (getLevels() - 1);
    }

    private void calculateTableSpace() {
        double areaPerTable = (double) getArea() / numberOfTablesPerLevel;
        if (areaPerTable < 2 || areaPerTable > 5) {
            throw new IllegalArgumentException("You can't fit this number of table in the office.");
        }
    }
}
