package lt.inntecTask.modelsDTO;

import lt.inntecTask.models.Person;

import javax.persistence.Entity;
import java.util.List;

public class RelativesDTO {
    private List<Person> son;
    private List<Person> daughter;
    private List<Person> husband;
    private List<Person> wife;
    private List<Person> father;
    private List<Person> mother;
    private List<Person> grandfather;
    private List<Person> grandmother;
    private List<Person> brother;
    private List<Person> sister;
    private List<Person> grandSon;
    private List<Person> grandDaughter;

    // TO DO: DESIGN PATTERN BUILDER
    public RelativesDTO() {
    }

    public List<Person> getSon() {
        return son;
    }

    public void setSon(List<Person> son) {
        this.son = son;
    }

    public List<Person> getDaughter() {
        return daughter;
    }

    public void setDaughter(List<Person> daughter) {
        this.daughter = daughter;
    }

    public List<Person> getHusband() {
        return husband;
    }

    public void setHusband(List<Person> husband) {
        this.husband = husband;
    }

    public List<Person> getWife() {
        return wife;
    }

    public void setWife(List<Person> wife) {
        this.wife = wife;
    }

    public List<Person> getFather() {
        return father;
    }

    public void setFather(List<Person> father) {
        this.father = father;
    }

    public List<Person> getMother() {
        return mother;
    }

    public void setMother(List<Person> mother) {
        this.mother = mother;
    }

    public List<Person> getGrandfather() {
        return grandfather;
    }

    public void setGrandfather(List<Person> grandfather) {
        this.grandfather = grandfather;
    }

    public List<Person> getGrandmother() {
        return grandmother;
    }

    public void setGrandmother(List<Person> grandmother) {
        this.grandmother = grandmother;
    }

    public List<Person> getBrother() {
        return brother;
    }

    public void setBrother(List<Person> brother) {
        this.brother = brother;
    }

    public List<Person> getSister() {
        return sister;
    }

    public void setSister(List<Person> sister) {
        this.sister = sister;
    }

    public List<Person> getGrandSon() {
        return grandSon;
    }

    public void setGrandSon(List<Person> grandSon) {
        this.grandSon = grandSon;
    }

    public List<Person> getGrandDaughter() {
        return grandDaughter;
    }

    public void setGrandDaughter(List<Person> grandDaughter) {
        this.grandDaughter = grandDaughter;
    }
}
