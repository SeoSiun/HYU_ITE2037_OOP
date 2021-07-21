public class User extends Member{

	public User(String id, String password, Movie[] movies){
		super(id, password, movies);
	}

	public User(Member member) {
		super(member);
	}

	@Override
	public String toSaveUserInfo() {
		return 0 + " " + super.toSaveUserInfo();
	}
}
