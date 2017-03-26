package trains;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.Node; 
import org.w3c.dom.NodeList;

public class TrainsXMLWorker {
	public static Trains loadTrainsLogFromFile(File file) {
		Trains trainsList = new Trains();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file.getAbsoluteFile());
			Element root = document.getDocumentElement();
			NodeList trains = root.getChildNodes();
			for (int i = 0; i < trains.getLength(); i++) {
				Node node = trains.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					Train train = getTrainFromNode(element);
					if (train != null) {
						trainsList.addTrain(train);
					}

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		return trainsList;
	}

	public static Train getTrainFromNode(Element trainElement) {
		if (!trainElement.getTagName().equals("train")) {
			return null;
		}
		String from = trainElement.getElementsByTagName("from").item(0).getTextContent();
		String to = trainElement.getElementsByTagName("to").item(0).getTextContent();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
		String dateText = trainElement.getElementsByTagName("date").item(0).getTextContent();
		Date date = new Date();
		try {
			date = sdf.parse(dateText);
		} catch (Exception e) {
			System.out.println("Error load date");
		}
		SimpleDateFormat sdfDeparture = new SimpleDateFormat("HH:mm");
		String departureText = trainElement.getElementsByTagName("departure").item(0).getTextContent();
		Date departureTime = new Date();
		try {
			departureTime = sdfDeparture.parse(departureText);
		} catch (Exception e) {
			System.out.println("Error load departure time");
		}
		
		int id = 0;
		Node trainId = trainElement;
		
		if (trainId.hasAttributes()) {
			Node idNode = trainId.getAttributes().item(0);
			id = Integer.valueOf(idNode.getNodeValue());
		}
		Train train = new Train(id,from, to, date, departureTime);
		return train;
	}

	private static Element elementFromTrain(Train train, Document document) {
		Element trainElement = document.createElement("train");
		trainElement.setAttribute("id", Integer.toString(train.getId()));
		Element from = document.createElement("from");
		from.setTextContent(train.getFrom());
		Element to = document.createElement("to");
		to.setTextContent(train.getTo());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Element date = document.createElement("date");
		date.setTextContent(sdf.format(train.getDate()));
		sdf = new SimpleDateFormat("HH:mm");
		Element departureTime = document.createElement("departure");
		departureTime.setTextContent(sdf.format(train.getDeparture()));
		trainElement.appendChild(from);
		trainElement.appendChild(to);
		trainElement.appendChild(date);
		trainElement.appendChild(departureTime);
		return trainElement;
	}
	
	public static void saveToXML(Trains trainsList, String fileName) { 
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); 
		try { 
			DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder(); 
			Document document = docBuilder.newDocument(); 
			Element root = document.createElement("trains"); 
			document.appendChild(root); 
			for (Train train : trainsList.getListTrain()) { 
				Element trainEl = elementFromTrain(train, document); 
				root.appendChild(trainEl); 
				} 
			TransformerFactory traF = TransformerFactory.newInstance(); 
			Transformer transformer = traF.newTransformer(); 
			DOMSource source = new DOMSource(document); 
			StreamResult stRes = new StreamResult(fileName); 
			transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes"); 
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2"); 
			transformer.transform(source, stRes); 
			} catch (ParserConfigurationException  | TransformerException e) 
		{ // TODO Auto-generated catch block e.printStackTrace(); 
		
	} 
		
	}
}
