/******************************************************************/

public class GrandFather {

    protected int _x;
	
	public GrandFather() {
		this(0);
	}
	
	public GrandFather(int x) {
		_x = x;
	}
    
    public boolean equals(Object obj) { /** equals 1 **/
        System.out.println("1");
		if (obj == null || !(obj instanceof GrandFather))
			return false;
		
		return _x == ((GrandFather)obj)._x;
	}
    
    public void smile() {
        System.out.println("GrandFather is smiling");
    }
    
    public void eat() {
        System.out.println("I'm eating");
    }
}

/******************************************************************/

public class Father extends GrandFather {

    private int _y;
	
	public Father() {
		this(0, 0);
	}
	
	public Father(int x, int y) {
		super(x);
		_y = y;
	}
    
    public boolean equals(Father obj) { /** equals 2 **/
    System.out.println("2");
		return super.equals(obj) && _y == obj._y;
	}
    
    public void smile() {
        System.out.println("Father is smiling");
    }
    
    public void run() {
        System.out.println("Father is running");
    }
}

/******************************************************************/

public class Son extends Father {

    public Son() {
		this(0, 0);
	}
	
	public Son(int x, int y) {
		super(x, y);
	}
    
    public boolean equals(Object obj) { /** equals 3 **/
    System.out.println("3");
		if (obj == null || !(obj instanceof Son))
			return false;

		return super.equals(obj);
	}
	
	public boolean equals(Son obj) { /** equals 4 **/
	System.out.println("4");
		return super.equals(obj);
	}
    
    public void smile() {
        System.out.println("Son is smiling");
    }
    
    public void run() {
        System.out.println("Son is running");
    }
}

/******************************************************************/

public class Daughter extends Father {

    public Daughter() {
		this(0, 0);
	}
	
    public Daughter(int x, int y) {
		super(x, y);
	}
    
    public boolean equals(Object obj) { /** equals 5 **/
    System.out.println("5");
		if (obj == null || !(obj instanceof Daughter))
			return false;
		
		return super.equals(obj);
	}
    
    public void smile() {
        System.out.println("Daughter is smiling");
    }
    
    public void run() {
        System.out.println("Daughter is running");
    }
    
    public void wonderWoman() {
        System.out.println("I'm Wonder Woman");
    }
}

/******************************************************************/

public class GrandSon extends Son {

    private int _z;
	
	public GrandSon() {
		this(0, 0, 0);
	}
	
	public GrandSon(int x, int y, int z) {
		super(x, y);
		_z = z;
	}
    
    public boolean equals(Object obj) { /** equals 6 **/
    System.out.println("6");
		if (obj == null || !(obj instanceof GrandSon))
			return false;
		
		return super.equals(obj) && _z == ((GrandSon)obj)._z;
	}
	
	
	public boolean equals(Father obj) { /** equals 7 **/
	System.out.println("7");
		return super.equals(obj);
	}
	
	public boolean equals(GrandSon obj) { /** equals 8 **/
	System.out.println("8");
		return super.equals(obj);
	}
    
    public void smile() {
        System.out.println("GrandSon is smiling");
    }
    
    public void run() {
        System.out.println("GrandSon is running");
    }
    
    public void play() {
        System.out.println("GrandSon is playing");
    }
}

/******************************************************************/
