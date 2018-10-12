package zl.bean;

public class TestUser extends BaseBean
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7935028333196453731L;
	private int id;
	private String username;
	private String password;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "TestUser [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
