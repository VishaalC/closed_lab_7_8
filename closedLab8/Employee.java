package closedLab8;

/**
 * Class representing employee.
 * Employee has only select perms.
 * Contains getters and setters for employee class
 */
public class Employee extends AbstractUser {
    private String name;
    private int empId;
    
    // setting employee perms
    public Employee() {
        setPermissions(false, false, false, true);
    }
    
    // used to set employee permissions
    private void setPermissions(boolean create, boolean delete, boolean update, boolean select) {
        this.canCreate = create;
        this.canDelete = delete;
        this.canUpdate = update;
        this.canSelect = select;
    }

    // getter for name.
    @Override
    public String getName() {
        return name;
    }
    
    // setter for name.
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    // getter for empId.
    @Override
    public int getEmpId() {
        return empId;
    }

    // setter for empId.
    @Override
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    
    // overriding toString to print custom message.
    @Override
    public String toString() {
        return "Employee [name=" + name + ", empId=" + empId + ", canCreate=" + canCreate + ", canDelete=" + canDelete
                + ", canUpdate=" + canUpdate + ", canSelect=" + canSelect + ", getName()=" + getName()
                + ", getEmpId()=" + getEmpId() + "]";
    }
}
