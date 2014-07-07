package com.chrylis.spr10903;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MediaTypeParameterController {

	@RequestMapping(value = "/entity", produces="application/x-spr-10903+json;version=1")
	public Version1Entity oldVersion() {
		return new Version1Entity("this should be in oldField");
	}

	@RequestMapping(value = "/entity", produces="application/x-spr-10903+json;version=2")
	public Version2Entity newVersion() {
		return new Version2Entity("this should be in newField");
	}
}
