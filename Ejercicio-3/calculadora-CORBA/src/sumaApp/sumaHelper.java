package sumaApp;

abstract public class sumaHelper {
    private static String _id = "IDL:sumaApp/suma:1.0";

    public static void insert(org.omg.CORBA.Any a, sumaApp.suma that) {
        org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static sumaApp.suma extract(org.omg.CORBA.Any a) {
        return read(a.create_input_stream());
    }

    private static org.omg.CORBA.TypeCode __typeCode = null;

    synchronized public static org.omg.CORBA.TypeCode type() {
        if (__typeCode == null) {
            __typeCode = org.omg.CORBA.ORB.init().create_interface_tc(sumaApp.sumaHelper.id(), "suma");
        }
        return __typeCode;
    }

    public static String id() {
        return _id;
    }

    public static sumaApp.suma read(org.omg.CORBA.portable.InputStream istream) {
        return narrow(istream.read_Object(_sumaStub.class));
    }

    public static void write(org.omg.CORBA.portable.OutputStream ostream, sumaApp.suma value) {
        ostream.write_Object((org.omg.CORBA.Object) value);
    }

    public static sumaApp.suma narrow(org.omg.CORBA.Object obj) {
        if (obj == null)
            return null;
        else if (obj instanceof sumaApp.suma)
            return (sumaApp.suma) obj;
        else if (!obj._is_a(id()))
            throw new org.omg.CORBA.BAD_PARAM();
        else {
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            sumaApp._sumaStub stub = new sumaApp._sumaStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

    public static sumaApp.suma unchecked_narrow(org.omg.CORBA.Object obj) {
        if (obj == null)
            return null;
        else if (obj instanceof sumaApp.suma)
            return (sumaApp.suma) obj;
        else {
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            sumaApp._sumaStub stub = new sumaApp._sumaStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

}
