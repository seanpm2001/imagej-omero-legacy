/*-
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2018 - 2022 Open Microscopy Environment:
 * 	- Board of Regents of the University of Wisconsin-Madison
 * 	- Glencoe Software, Inc.
 * 	- University of Dundee
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */
package net.imagej.omero.legacy.text;

import net.imagej.legacy.convert.roi.AbstractRoiToMaskPredicateConverter;

import ij.gui.TextRoi;

import org.scijava.Priority;
import org.scijava.convert.Converter;
import org.scijava.plugin.Plugin;

/**
 * Wraps a {@link TextRoi} to a {@link TextRoiWrapper}.
 * <p>
 * This converter only exists for getting {@link TextRoi}s from ImageJ 1.x into
 * OMERO. It should <strong>NOT</strong> be used for other purposes.
 * </p>
 *
 * @author Alison Walter
 */
@Plugin(type = Converter.class, priority = Priority.HIGH)
public class TextRoiToTextRoiWrapper extends
AbstractRoiToMaskPredicateConverter<TextRoi, TextRoiWrapper>
{

	@Override
	public Class<TextRoi> getInputType() {
		return TextRoi.class;
	}

	@Override
	public Class<TextRoiWrapper> getOutputType() {
		return TextRoiWrapper.class;
	}

	@Override
	public TextRoiWrapper convert(TextRoi src) {
		return new TextRoiWrapper(src);
	}

	@Override
	public boolean supportedType(TextRoi src) {
		return !(src instanceof OMEROTextWrapper);
	}

}
