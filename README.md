#  Data Integration: Dog Breeds Catalog

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/XML-006699?style=for-the-badge&logo=w3c&logoColor=white" alt="XML" />
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven" />
  <img src="https://img.shields.io/badge/JSoup-43B02A?style=for-the-badge" alt="JSoup" />
  <img src="https://img.shields.io/badge/Regex-000000?style=for-the-badge" alt="Regex" />
  <img src="https://img.shields.io/badge/XPath_|_XQuery_|_XSLT-1E8CBE?style=for-the-badge" alt="XPath/XQuery/XSLT" />
</div>

<br>

Practical project developed for the **Data Integration** course of the Bachelor's degree in Computer Engineering at **ISEC - Polytechnic Institute of Coimbra** (Academic Year 2025/2026).

This Java Swing application aims to extract, integrate, and unify heterogeneous, distributed, and autonomous data about various dog breeds, structuring all the information into a rigorous and validated XML model.

---

##  Data Sources & Extraction

The system extracts information from two different web sources and resolves conflicts to create a unified view:
*  **Royal Kennel Club**: Web scraping extraction using the **JSoup** library to obtain details such as breed group, size, exercise level, grooming needs, and lifespan.
*  **Wikipedia (English)**: Unstructured text extraction using **Regular Expressions (Regex)** to capture the country of origin, coat colors, and biometric data (weight and height, with distinction between male/female). All metric/imperial systems are normalized and converted by the extraction algorithm.

---

##  Main Features

 **Global XML Model (JDOM2)**: The collected information is stored in two relational files (`racas.xml` for the dog index and `detalhes.xml` for technical attributes).
 **Semantic Validation (DTD and XSD)**: The application integrates a dynamic injection mechanism that validates the structure and data typing of XML files against strict DTD and XSD schemas at runtime.
  **Data Management (CRUD)**: Interface for dynamic search, adding new breeds to the database, editing specific attributes, and cross-deleting (maintaining integrity between the two XML files).
 **Advanced Searches (XPath)**: Engine with dozens of multi-criteria filters natively implemented in XPath (e.g., search by weight, size, origin, crossing three simultaneous criteria, breeds with missing data, etc.).
 **Transformations (XSLT)**: Generation of transformed outputs, including:
  * Visual HTML catalog with photo galleries.
  * Individual technical sheets in HTML and pure XML format.
  * Restructuring of the original XML file grouping dogs by size category.
  **Report Generation (XQuery)**: Integration with the **Saxon HE** engine to generate complex statistical reports, lifespan rankings, and breed distribution by groups, exporting the results to plain text (`.txt`).

---

##  Repository Structure

├── docs/                      # Project documentation and Final Report
├── src/main/java/             # Java source code (Wrappers, UI, Models, XML Functions)
├── pom.xml                    # Maven configuration and dependencies
├── racas.xml / detalhes.xml   # Generated structured database
├── *.xsd / *.dtd              # Validation schema files (XML Schema and DTD)
├── *.xsl                      # XSLT transformation files

##  Authors
Maria Capitão

Thuane Lyra
