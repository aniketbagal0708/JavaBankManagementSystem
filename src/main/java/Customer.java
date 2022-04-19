
public class Customer
{

	private int cId;
	private String fname;
	private String lname;
	private int age;
	private String aadhar_no;
	private String phone_no;
	private String address;
	private String pass;
	
	public Customer(int cId,String fname,String lname,int age,String aadhar_no,String phone_no,String address,String pass)
	{
		super();
		this.cId = cId;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.aadhar_no = aadhar_no;
		this.phone_no = phone_no;
		this.address = address;
		this.pass = pass;
	}
	
	public int getId()
	{
		return cId;
	}
	public void setId()
	{
		this.cId = cId;
	}
	
	public String getFname()
	{
		return fname;
	}
	
	public void setFname()
	{
		this.fname = fname;
	}
	
	public String getLname()
	{
		return lname;
	}
	
	public void setLname()
	{
		this.lname = lname;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge()
	{
		this.age = age;
	}
	
	public String getAadhar()
	{
		return aadhar_no;
	}
	
	public void setAadhar()
	{
		this.aadhar_no = aadhar_no;
	}
	
	public String getPhone()
	{
		return phone_no;
	}
	public void setPhone()
	{
		this.phone_no = phone_no;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress()
	{
		this.address = address;
	}
	
	public String getPass()
	{
		return pass;
	}
	
	public void setPass()
	{
		this.pass = pass;
	}
	
}
