class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.gender == Sex.MALE &&
            p.getAge() >= 18 &&
            p.getAge() <= 25;
    }
}