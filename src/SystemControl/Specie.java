package SystemControl;

public class Specie {
    private String nameSpecie;
    private final Planet planet;
    private int levelDangerBase;

    public Specie(String nameSpecie, Planet planet) {
        this.planet = planet;

        switch (planet){
            case MERCURY:
                this.levelDangerBase = 10;
                break;
            case MARS:
                this.levelDangerBase = 20;
                break;
            case VENUS:
                this.levelDangerBase = 30;
                break;
            case SATURN:
                this.levelDangerBase = 40;
                break;
            case URANOS:
                this.levelDangerBase = 50;
                break;
            case JUPITER:
                this.levelDangerBase = 60;
                break;
            case NEPTUNE:
                this.levelDangerBase = 70;
                break;
        }
    }

    public int getLevelDangerBase() {
        return levelDangerBase;
    }

    public void setLevelDangerBase(int levelDangerBase) {
        this.levelDangerBase = levelDangerBase;
    }

    public Planet getPlanet() {
        return planet;
    }

    public String getNameSpecie() {
        return nameSpecie;
    }

    public void setNameSpecie(String nameSpecie) {
        this.nameSpecie = nameSpecie;
    }
}
