package closedLab8;

public class HRUser extends AbstractUser {
    private String name;
    private int empId;

    public HRUser() {
        setPermissions(true, true, true, true);
    }

    private void setPermissions(boolean create, boolean delete, boolean update, boolean select) {
        this.canCreate = create;
        this.canDelete = delete;
        this.canUpdate = update;
        this.canSelect = select;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getEmpId() {
        return empId;
    }

    @Override
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "HRUser [name=" + name + ", empId=" + empId + ", canCreate=" + canCreate + ", canDelete=" + canDelete
                + ", canUpdate=" + canUpdate + ", canSelect=" + canSelect + ", getName()=" + getName()
                + ", getEmpId()=" + getEmpId() + "]";
    }
}
