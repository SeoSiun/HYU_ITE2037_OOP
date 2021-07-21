public class Manager extends Member {

	public Manager(String id, String password, Movie[] movies) {
        super(id, password, movies);
    }

    public Manager(Member member) {
		super(member);
	}

	@Override
    public String toSaveUserInfo() {
        return 1 + " " + super.toSaveUserInfo();
    }
}