package SystemControl;

public class Alien implements DangerEvaluation{
    private int id;
    private String name;
    private Specie specie;
    private int lvlDanger;
    private final Behaviour behaviour;
    private boolean isQuarantine;

    public Alien(int id, String name, Specie specie, int lvlDanger, Behaviour behaviour) {
        this.id = id;
        this.name = name;
        this.specie = specie;
        this.lvlDanger = lvlDanger;
        this.behaviour = behaviour;
        this.isQuarantine = this.isDanger();
    }

    @Override
    public int dangerEvaluation() {
        int danger = lvlDanger + this.getSpecie().getLevelDangerBase();

        switch (this.behaviour) {
            case VIOLENT -> danger += 20;
            case TRUCULENT -> danger += 16;
            case NEUTRAL -> danger -= 1;
            case COMMUNICATIVE -> danger -= 16;
            case CALM -> danger -= 20;
        }

        return danger;
    }

    @Override
    public boolean isDanger() {
       return this.dangerEvaluation() > 35;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public int getLvlDanger() {
        return lvlDanger;
    }

    public void setLvlDanger(int lvlDanger) {
        this.lvlDanger = lvlDanger;
    }

    public Behaviour getBehaviour() {
        return behaviour;
    }

    public boolean isQuarantine() {
        return isQuarantine;
    }

    public void setQuarantine(boolean quarantine) {
        isQuarantine = quarantine;
    }
}
