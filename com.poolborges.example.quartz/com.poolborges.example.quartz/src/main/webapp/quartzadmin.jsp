<%-- 
    Document   : quartzadmin
    Created on : 28/Set/2012, 21:07:23
    Author     : Borges
--%>

<%@page import="org.quartz.impl.matchers.GroupMatcher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="org.quartz.ee.servlet.QuartzInitializerServlet" %>
<%@page import="org.quartz.impl.StdSchedulerFactory" %>
<%@page import="org.quartz.*" %>
<%@page import="java.util.*" %>
<%
    String jobNameToRun = request.getParameter("jobNameToRun");
    String groupNameToRun = request.getParameter("groupNameToRun");
    String btnTrigger = request.getParameter("btnTrigger");
    StdSchedulerFactory factory = (StdSchedulerFactory) pageContext.getServletContext().getAttribute(QuartzInitializerServlet.QUARTZ_FACTORY_KEY);
    Scheduler scheduler = factory.getScheduler();
    JobKey jobKey1 = new JobKey(jobNameToRun, groupNameToRun);
    if ("Trigger Now".equals(btnTrigger)) {
        scheduler.triggerJob(jobKey1);
%>
Job <%=jobNameToRun%> triggered.<BR>
<%
    }

    for (String groupName : scheduler.getJobGroupNames()) {
%>
<p>GroupName:<%=groupName%></p><br>
<table border="1">
    <tr><td><b>JobName</b></td><td><b>Next Fire Time</b></td><td>&nbsp;</td></tr>
    <%
        for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher
                .jobGroupEquals(groupName))) {
            String jobName = jobKey.getName();
            String jobGroup = jobKey.getGroup();
            // get job's trigger
            List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
            Date nextFireTime = triggers.get(0).getNextFireTime();
    %>       
    <tr><td><%=jobName%></td><td><%=nextFireTime%></td><td><form><input type="hidden" name="groupNameToRun" value="<%=groupName%>"/><input type="hidden" name="jobNameToRun" value="<%=jobName%>"/><input type="submit" name="btnTrigger" value="Trigger Now"/></form></tr>
    <%      
        }
    %>
</table>
<%
    }
%>
