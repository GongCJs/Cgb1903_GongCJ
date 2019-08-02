package cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.syntax;

import cn.gcjlearn.java.base.oop.features.JDK1_8.Lambda.Data.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Syntax04 {
	public static void main(String[] args) {
		PersonCreate01 personCreate
				=() -> new Person();

		PersonCreate01 personCreate1
				=Person::new;
		Person person = personCreate1.createPersonNoArg();

		PersonCreate02 personCreate02
				=Person::new;
		personCreate02.createPersonNoArg("gcj",22);
	}
}

@FunctionalInterface
interface PersonCreate01{
	Person createPersonNoArg();
}
@FunctionalInterface
interface PersonCreate02{
	Person createPersonNoArg(String name,Integer age);

}

