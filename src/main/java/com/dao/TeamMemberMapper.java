package com.dao;




import org.springframework.stereotype.Repository;
import com.model.TeamMember;




@Repository
public interface TeamMemberMapper extends BaseMapper<TeamMember, String> {

	public int insert(TeamMember member);
	public int update(String id);
	public void delete(String id);
	public TeamMember load(String id);
}
