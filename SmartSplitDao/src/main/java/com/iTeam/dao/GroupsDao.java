package com.iTeam.dao;

import com.iTeam.common.Groups;
import com.iTeam.common.GroupMembers;

import java.util.ArrayList;

/**
 * Created by rahuldhamnani on 4/17/16.
 */
public interface GroupsDao {
     String addGroup(String name, String createdBy, String dateCreated) throws Exception;
     ArrayList<Groups> getGroupDetails(String name) throws Exception;
     String addGroupMember(ArrayList<GroupMembers> addlist) throws Exception;
}
