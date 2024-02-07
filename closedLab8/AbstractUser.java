package closedLab8;

/**
 * Abstract class used to create employee and HR objects.
 */
public abstract class AbstractUser {
   
	public boolean canCreate;
    public boolean canDelete;
    public boolean canUpdate;
    public boolean canSelect;

    abstract String getName();

    abstract int getEmpId();

    abstract void setName(String name);

    abstract void setEmpId(int empId);

    public boolean canCreate() {
        return canCreate;
    }

    public boolean canDelete() {
        return canDelete;
    }

    public boolean canUpdate() {
        return canUpdate;
    }

    public boolean canSelect() {
        return canSelect;
    }
}
