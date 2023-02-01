package facade;

public class Hello {

    public String sayHello(Object name) {

        if(name instanceof String[]) {
            StringBuilder returnstring = new StringBuilder("Hello, ");
            String[] Strings = (String[]) name;
            returnstring.append(Strings[0]);
            for(int i = 1; i < Strings.length; i++) {
                if (Strings.length <= 2) {
                    returnstring.append(" and ").append(Strings[i]);
                }
                if (Strings.length > 2) {
                    returnstring.append(", ").append(Strings[i]).append("and").append(Strings[2]);
                }
            }
            return returnstring.toString();
        }

        if(name == null) {
            return "Hello, my friend";
        }

        if(name instanceof String) {
            if(name == ((String) name).toUpperCase())
            return "HELLO " + name + "!";
        }
        return "Hello " + name;
    }
}
