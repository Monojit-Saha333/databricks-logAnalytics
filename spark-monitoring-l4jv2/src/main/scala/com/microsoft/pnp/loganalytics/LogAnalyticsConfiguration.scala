package com.microsoft.pnp.loganalytics

import org.apache.spark.internal.Logging

private[loganalytics] trait LogAnalyticsConfiguration extends Logging {
  val workspaceId: String = {
    val value = getWorkspaceId
    require(value.isDefined, "A Log Analytics Workspace ID is required")
    logInfo(s"Setting workspaceId to ${value.get}")
    value.get

  }
  val secret: String = {
    val value = getSecret
    require(value.isDefined, "A Log Analytics Workspace Key is required")
    value.get
  }
  val logType: String = {
    val value = getLogType
    logInfo(s"Setting logType to $value")
    value
  }
  val timestampFieldName: String = {
    val value = getTimestampFieldName
    logInfo(s"Setting timestampNameField to $value")
    value.orNull
  }

  protected def getWorkspaceId: Option[String]

  protected def getSecret: Option[String]

  protected def getLogType: String

  protected def getTimestampFieldName: Option[String]
}
