import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class SkillService {

  constructor(private http: HttpClient) { }

  saveProfileSkill(idUser:number, idSkill:number, skillKnowledgeLevel:number): Observable<any>{
    const profileSkillDetails = {id_profile: idUser,id_skill:idSkill,skill_knowledge_level:skillKnowledgeLevel};
    return this.http.post('http://localhost:8080/EmployeeAppFront_war/rest/profileskills/save', profileSkillDetails);
  }
  getAllTechAreas(): Observable<any>{
      return this.http.get('http://localhost:8080/EmployeeAppFront_war/rest/skills/technologyareas');

  }
  saveSkill(skillName: string, techArea: string): Observable<any>{
    const skillDetails = {skillName: skillName, technologyArea: techArea};
    return this.http.post('http://localhost:8080/EmployeeAppFront_war/rest/skills/save',skillDetails);

  }

  idSKill(name:string) :Observable<any> {

    return this.http.get('http://localhost:8080/EmployeeAppFront_war/rest/skills/findbyname?name='+name);
  }
}
