<?xml version="1.0" encoding="UTF-8"?>
<!-- THIS FILE IS USED AS A PART OF THE UNIT TESTING FRAMEWORK -->
<!-- PLEASE DO NOT DELETE -->

<xsl:stylesheet version="3.0"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:ctx="java:com.capeclear.mediation.MediationContext"
    xmlns:jt="http://saxon.sf.net/java-type"
    xmlns:jmap="java:java.util.Map"
    xmlns:tube="java:com.capeclear.mediation.impl.cc.MediationTube">

    <xsl:output method="xml" indent="no"/>

    <xsl:param name="inApiVersion" as="xs:string"/>
    <xsl:param name="inBuildRequestDataLocationId" as="xs:string"/>

    <xsl:variable name="ctx" select="tube:getCurrentMediationContext()"/>
    <xsl:variable name="map" select="ctx:getProperty($ctx, $inBuildRequestDataLocationId)" as="jt:java.util.Map"/>

    <xsl:template match="/">
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bsvc="urn:com.workday/bsvc">
           <soapenv:Header>
              <bsvc:Workday_Common_Header>
                 <bsvc:Include_Reference_Descriptors_In_Response>false</bsvc:Include_Reference_Descriptors_In_Response>
              </bsvc:Workday_Common_Header>
           </soapenv:Header>
           <soapenv:Body>
              <bsvc:Get_Workers_Request bsvc:version="{$inApiVersion}">
                 <bsvc:Request_References bsvc:Skip_Non_Existing_Instances="true" bsvc:Ignore_Invalid_References="true">
                    <bsvc:Worker_Reference>
                       <bsvc:ID bsvc:type="{jmap:get($map, 'WorkerReferenceIdType')}"><xsl:value-of select="jmap:get($map, 'WorkerReferenceId')"/></bsvc:ID>
                    </bsvc:Worker_Reference>
                 </bsvc:Request_References>
                 <bsvc:Response_Filter>
                    <bsvc:Page>1</bsvc:Page>
                    <bsvc:Count>1</bsvc:Count>
                 </bsvc:Response_Filter>
                 <bsvc:Response_Group>
                    <bsvc:Include_Reference>true</bsvc:Include_Reference>
                    <bsvc:Include_Personal_Information>false</bsvc:Include_Personal_Information>
                    <bsvc:Include_Additional_Jobs>false</bsvc:Include_Additional_Jobs>
                    <bsvc:Include_Employment_Information>true</bsvc:Include_Employment_Information>
                    <bsvc:Include_Compensation>false</bsvc:Include_Compensation>
                    <bsvc:Include_Organizations>false</bsvc:Include_Organizations>
                    <bsvc:Exclude_Organization_Support_Role_Data>true</bsvc:Exclude_Organization_Support_Role_Data>
                    <bsvc:Exclude_Location_Hierarchies>true</bsvc:Exclude_Location_Hierarchies>
                    <bsvc:Exclude_Cost_Centers>true</bsvc:Exclude_Cost_Centers>
                    <bsvc:Exclude_Cost_Center_Hierarchies>true</bsvc:Exclude_Cost_Center_Hierarchies>
                    <bsvc:Exclude_Companies>true</bsvc:Exclude_Companies>
                    <bsvc:Exclude_Company_Hierarchies>true</bsvc:Exclude_Company_Hierarchies>
                    <bsvc:Exclude_Matrix_Organizations>true</bsvc:Exclude_Matrix_Organizations>
                    <bsvc:Exclude_Pay_Groups>true</bsvc:Exclude_Pay_Groups>
                    <bsvc:Exclude_Regions>true</bsvc:Exclude_Regions>
                    <bsvc:Exclude_Region_Hierarchies>true</bsvc:Exclude_Region_Hierarchies>
                    <bsvc:Exclude_Supervisory_Organizations>true</bsvc:Exclude_Supervisory_Organizations>
                    <bsvc:Exclude_Teams>true</bsvc:Exclude_Teams>
                    <bsvc:Exclude_Custom_Organizations>true</bsvc:Exclude_Custom_Organizations>
                    <bsvc:Include_Roles>false</bsvc:Include_Roles>
                    <bsvc:Include_Management_Chain_Data>false</bsvc:Include_Management_Chain_Data>
                    <bsvc:Include_Multiple_Managers_in_Management_Chain_Data>false</bsvc:Include_Multiple_Managers_in_Management_Chain_Data>
                    <bsvc:Include_Benefit_Enrollments>false</bsvc:Include_Benefit_Enrollments>
                    <bsvc:Include_Benefit_Eligibility>false</bsvc:Include_Benefit_Eligibility>
                    <bsvc:Include_Related_Persons>false</bsvc:Include_Related_Persons>
                    <bsvc:Include_Qualifications>false</bsvc:Include_Qualifications>
                    <bsvc:Include_Employee_Review>false</bsvc:Include_Employee_Review>
                    <bsvc:Include_Goals>false</bsvc:Include_Goals>
                    <bsvc:Include_Development_Items>false</bsvc:Include_Development_Items>
                    <bsvc:Include_Skills>false</bsvc:Include_Skills>
                    <bsvc:Include_Photo>false</bsvc:Include_Photo>
                    <bsvc:Include_Worker_Documents>false</bsvc:Include_Worker_Documents>
                    <bsvc:Include_Transaction_Log_Data>false</bsvc:Include_Transaction_Log_Data>
                    <bsvc:Include_Subevents_for_Corrected_Transaction>false</bsvc:Include_Subevents_for_Corrected_Transaction>
                    <bsvc:Include_Subevents_for_Rescinded_Transaction>false</bsvc:Include_Subevents_for_Rescinded_Transaction>
                    <bsvc:Include_Succession_Profile>false</bsvc:Include_Succession_Profile>
                    <bsvc:Include_Talent_Assessment>false</bsvc:Include_Talent_Assessment>
                    <bsvc:Include_Employee_Contract_Data>false</bsvc:Include_Employee_Contract_Data>
                    <bsvc:Include_Contracts_for_Terminated_Workers>false</bsvc:Include_Contracts_for_Terminated_Workers>
                    <bsvc:Include_Collective_Agreement_Data>false</bsvc:Include_Collective_Agreement_Data>
                    <bsvc:Include_Probation_Period_Data>false</bsvc:Include_Probation_Period_Data>
                    <bsvc:Include_Extended_Employee_Contract_Details>false</bsvc:Include_Extended_Employee_Contract_Details>
                    <bsvc:Include_Feedback_Received>false</bsvc:Include_Feedback_Received>
                    <bsvc:Include_User_Account>false</bsvc:Include_User_Account>
                    <bsvc:Include_Career>false</bsvc:Include_Career>
                    <bsvc:Include_Account_Provisioning>false</bsvc:Include_Account_Provisioning>
                    <bsvc:Include_Background_Check_Data>false</bsvc:Include_Background_Check_Data>
                    <bsvc:Include_Contingent_Worker_Tax_Authority_Form_Information>false</bsvc:Include_Contingent_Worker_Tax_Authority_Form_Information>
                    <bsvc:Exclude_Funds>true</bsvc:Exclude_Funds>
                    <bsvc:Exclude_Fund_Hierarchies>true</bsvc:Exclude_Fund_Hierarchies>
                    <bsvc:Exclude_Grants>true</bsvc:Exclude_Grants>
                    <bsvc:Exclude_Grant_Hierarchies>true</bsvc:Exclude_Grant_Hierarchies>
                    <bsvc:Exclude_Business_Units>true</bsvc:Exclude_Business_Units>
                    <bsvc:Exclude_Business_Unit_Hierarchies>true</bsvc:Exclude_Business_Unit_Hierarchies>
                    <bsvc:Exclude_Programs>true</bsvc:Exclude_Programs>
                    <bsvc:Exclude_Program_Hierarchies>true</bsvc:Exclude_Program_Hierarchies>
                    <bsvc:Exclude_Gifts>true</bsvc:Exclude_Gifts>
                    <bsvc:Exclude_Gift_Hierarchies>true</bsvc:Exclude_Gift_Hierarchies>
                 </bsvc:Response_Group>
              </bsvc:Get_Workers_Request>
           </soapenv:Body>
        </soapenv:Envelope>
    </xsl:template> 
</xsl:stylesheet>
