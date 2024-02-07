package closedLab8;

/**
 * Class used to to represent an employee object.
 * Employee can perform creation, deletion, update and selection.
 */
public class HRUser extends AbstractUser {
    private String name;
    private int empId;
    
    // setting HRUser permissions.
    public HRUser() {
        setPermissions(true, true, true, true);
    }
    
    // initializing permss
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
    
    // override toString to print custom message.
    @Override
    public String toString() {
        return "HRUser [name=" + name + ", empId=" + empId + ", canCreate=" + canCreate + ", canDelete=" + canDelete
                + ", canUpdate=" + canUpdate + ", canSelect=" + canSelect + ", getName()=" + getName()
                + ", getEmpId()=" + getEmpId() + "]";
    }
}
