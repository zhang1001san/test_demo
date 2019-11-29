package com.it.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class RowModel extends BaseRowModel {
    @ExcelProperty(value = "CID", index = 0)
    private String cid;

    @ExcelProperty(value = "Portal Url", index = 1)
    private String portalUrl;

    @ExcelProperty(value = "CodingStandards", index = 2)
    private String codingStandards;

    @ExcelProperty(value = "Checker", index = 3)
    private String checker;

    @ExcelProperty(value = "Type", index = 4)
    private String type;

    @ExcelProperty(value = "Category", index = 5)
    private String category;

    @ExcelProperty(value = "Tool", index = 6)
    private String tool;

    @ExcelProperty(value = "ToolVersion", index = 7)
    private String toolVersion;

    @ExcelProperty(value = "Language", index = 8)
    private String language;

    @ExcelProperty(value = "ClearanceRequirement", index = 9)
    private String clearanceRequirement;

    @ExcelProperty(value = "Module", index = 10)
    private String module;

    @ExcelProperty(value = "First Detected Time", index = 11)
    private String firstDetectedTime;

    @ExcelProperty(value = "Defect Status", index = 12)
    private String defectStatus;

    @ExcelProperty(value = "File", index = 13)
    private String file;

    @ExcelProperty(value = "Line Number", index = 14)
    private String lineNumber;

    @ExcelProperty(value = "Function", index = 15)
    private String function;

    @ExcelProperty(value = "MergeKey", index = 16)
    private String mergeKey;

    @ExcelProperty(value = "Occurrence Count", index = 17)
    private String occurrenceCount;
    @ExcelProperty(value = "CVSS", index = 18)
    private String cvss;

    @ExcelProperty(value = "Severity", index = 19)
    private String severity;

    @ExcelProperty(value = "微服务", index = 20)
    private String microService;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPortalUrl() {
        return portalUrl;
    }

    public void setPortalUrl(String portalUrl) {
        this.portalUrl = portalUrl;
    }

    public String getCodingStandards() {
        return codingStandards;
    }

    public void setCodingStandards(String codingStandards) {
        this.codingStandards = codingStandards;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getToolVersion() {
        return toolVersion;
    }

    public void setToolVersion(String toolVersion) {
        this.toolVersion = toolVersion;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getClearanceRequirement() {
        return clearanceRequirement;
    }

    public void setClearanceRequirement(String clearanceRequirement) {
        this.clearanceRequirement = clearanceRequirement;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFirstDetectedTime() {
        return firstDetectedTime;
    }

    public void setFirstDetectedTime(String firstDetectedTime) {
        this.firstDetectedTime = firstDetectedTime;
    }

    public String getDefectStatus() {
        return defectStatus;
    }

    public void setDefectStatus(String defectStatus) {
        this.defectStatus = defectStatus;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getMergeKey() {
        return mergeKey;
    }

    public void setMergeKey(String mergeKey) {
        this.mergeKey = mergeKey;
    }

    public String getOccurrenceCount() {
        return occurrenceCount;
    }

    public void setOccurrenceCount(String occurrenceCount) {
        this.occurrenceCount = occurrenceCount;
    }

    public String getCvss() {
        return cvss;
    }

    public void setCvss(String cvss) {
        this.cvss = cvss;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMicroService() {
        return microService;
    }

    public void setMicroService(String microService) {
        this.microService = microService;
    }
}
