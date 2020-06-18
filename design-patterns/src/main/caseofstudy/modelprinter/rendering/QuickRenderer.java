package main.caseofstudy.modelprinter.rendering;

import main.caseofstudy.modelprinter.documentstructure.BaseObject;

public class QuickRenderer implements BaseObjectRenderer {

	@Override
	public String render(BaseObject object) {
		return "Quick Render:"+object.getName();
	}

}
