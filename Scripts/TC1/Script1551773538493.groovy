import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.verifyElementPresent(findTestObject(
	'Object Repository/Page_CURA Healthcare Service/h1_CURA Healthcare Service'),
	10,
	FailureHandling.STOP_ON_FAILURE)

// following verification will fail. This is intentional.
// just to see what happens when a built-in keyword failed.
def verificationResult = 
	WebUI.verifyElementAttributeValue(
		findTestObject('Page_CURA Healthcare Service_top/a_Make Appointment'),
		'href',
		'https://www.google.com/',   // this is a wrong URL
		5,
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.closeBrowser()