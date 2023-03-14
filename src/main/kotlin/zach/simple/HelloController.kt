package zach.simple

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping


@RestController
class HelloController {

 @GetMapping("/hello")
 fun get() : String = "Hello"

 

}