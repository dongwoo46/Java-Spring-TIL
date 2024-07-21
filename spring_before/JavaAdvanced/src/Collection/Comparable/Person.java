package Collection.Comparable;


//Collections.sort()를 사용하고싶으면
// 해당 클래스가 comparable 인터페이스 구현해야함
public class Person implements Comparable<Person> {
    private String name;
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person other = (Person) obj;
            return this.id.equals(other.id);
        } else {
            return false;
        }
    }

    // compareTo
    // return 값
    // - 양수 : 자리바꿈
    // - 음수 : 그대로
    // - 0 : 그대로
    @Override
    public int compareTo(Person o) {
        // 이름순으로 (String의 메서드 그대로 사용)
//        return this.name.compareTo(o.name);

        // 나이순으로
        return Integer.parseInt(o.id)-Integer.parseInt(this.id);

    }
}
