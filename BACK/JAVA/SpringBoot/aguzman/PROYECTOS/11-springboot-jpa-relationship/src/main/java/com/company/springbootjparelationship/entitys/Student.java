package com.company.springbootjparelationship.entitys;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;


    /*
     * Prohibido CascadeType."REMOVE":
     * - por reglas de integridad y FORANEAS a otros MUCHOS-A-MUCHOS
     * - porque es compartido uno ID con el otro ID y visceversa
     */
    @JoinTable( name = "students_courses_ti" //->nombre-tabla-intermedia
        ,joinColumns        = {@JoinColumn(name= "fk_student_id")}     //llave-foranea-principal-PADRE<Student>
        ,inverseJoinColumns = {@JoinColumn(name = "fk_id_courses_id")} //llave-foranea-secundaria-HIJA<Course>
        ,uniqueConstraints = {@UniqueConstraint(columnNames = { "fk_student_id", "fk_id_courses_id" })} //Alumno no puede tener dos cursos repetidos "y" Curso no puede tener dos alumnos repetidos
    )
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<Course> courses;


    public Student() {
        // this.courses = new HashSet<>();   //No mantiene orden
        this.courses = new LinkedHashSet<>();//mantiene orden
    }
    public Student(String name, String lastname) {
        this(); //->llama constrctor vacio: por si necesito instanciar la lista."course" para datos
        this.name = name;
        this.lastname = lastname;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Set<Course> getCourses() {
        return courses;
    }
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


    public Student addCourse(Course course) {
        this.courses.add(course);          //Padre-a->Hija
        course.getStudents().add(this);    //Hija-a->Padre (inversa)
        return this;
    }
    public void removeCourse(Course course) {
        this.courses.remove(course);       //Padre-a->Hija
        course.getStudents().remove(this); //Hija-a->Padre (inversa)
    }


    /*
     * HASHCODE/EQUALS
     * Para que <Course."students"> en su relacion Bidi-reccional
     * pueda  a esta clase <Student>(Agregar, Consultar, Eliminar):
     *      - MEDIANTE LOS ATRIBUTOS, y no por la instancia
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "{id=" + id +
                ", name=" + name +
                ", lastname=" + lastname +
                ", courses=" + courses +
                "]";
    }
}
