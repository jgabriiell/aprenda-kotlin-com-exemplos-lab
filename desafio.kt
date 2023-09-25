class Users(val name: String, var hoursCompleted: Int)

data class EducacionalContent(var name: String, var duration: Int)

class Training() {
    
    val registered = mutableListOf<Users>()
    
    fun enroll(student: Users, content: EducacionalContent) {
        registered.add(student)
       	student.hoursCompleted += content.duration
        println("Student ${student.name} enrolled in the ${content.name} with ${content.duration} hours")
    }
    
    fun viewStudentEnrolled() {
        for (students in registered) {
            println("${students.name}")
        }
    }
    
    fun viewStudentLevel(student: Users): String {
        if (student.hoursCompleted <= 3) {
            return "Basic"
        }
        if (student.hoursCompleted <= 6) {
            return "Intermediate"
        } else {
            return "Advanced"
        }
    }
    
    fun showStudentData(student: Users): Unit {
        println("Name: ${student.name}, Level: ${viewStudentLevel(student)}")
    }
}

fun main() {
    val student1 = Users("Gabriel", 0)
    
    val educationalContent1 = EducacionalContent("Basic Kotlin course", 3)
    val educationalContent2 = EducacionalContent("Java and Spring Boot course", 5)
    
    var training1 = Training()
    
    training1.enroll(student1, educationalContent1)
    training1.showStudentData(student1)
    
    training1.enroll(student1, educationalContent2)
    training1.showStudentData(student1)
}
