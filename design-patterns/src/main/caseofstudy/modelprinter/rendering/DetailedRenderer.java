package main.caseofstudy.modelprinter.rendering;

import main.caseofstudy.modelprinter.documentstructure.BaseObject;

public class DetailedRenderer implements BaseObjectRenderer {

	@Override
	public String render(BaseObject object) {
		return "Detailed Render:"+object.getName();
	}

}
