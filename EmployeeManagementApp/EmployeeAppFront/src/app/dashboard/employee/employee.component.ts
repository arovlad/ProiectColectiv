import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
// import {ProjectsService} from '../../../services/projects.service';
import {ActivatedRoute} from '@angular/router';
import {IEmployeeInfo} from './employeeInfo';
import {IProfileInfo} from './profileInfo';
import {SkillService} from '../../services/skill.service';
import {ILoginInformation} from '../../auth/login/loginInformation';
import {ProfileService} from '../../services/profile.service';
import {AppComponent} from '../../app.component';

@Component({
  selector: 'app-my-profile',
  templateUrl: './employee.component.html'
})
export class EmployeeComponent implements OnInit {
  id = 0;
  techArea = '';
  idUser = 0;
  idProfile = 0;
  firstName = '';
  consultingLevel = '';
  lastName = '';
  picture = 'assets/profile.png ';
  verified = 0;
  equals = 0;
  region = '';
  insertSkill = '';
  skills: Array<any> = [];
  myskills: Array<any> = [];
  techAreas: Array<any> = [];
  public list: IEmployeeInfo[] = [];
  name = '';
  skillLevel = 0;
  idSkill = 0;
  isVisible = false;
  role = '';

  constructor(private route: ActivatedRoute, private skillService: SkillService, private profileService: ProfileService) {
  }

  ngOnInit(): void {
    if (localStorage.getItem('role') !== '1') {
      this.isVisible = true;
    }
    // @ts-ignore
    this.id = +this.route.snapshot.paramMap.get('id');
    // @ts-ignore
    this.idUser = +localStorage.getItem('id');
    if (this.id === this.idUser) {
      this.equals = 1;
    }
    this.id = Number(this.id);
    this.getAllTechAreas();
    this.getAllTechAreas2();
    this.profileService.getData(this.id).subscribe(
      response => {
        const profileInfo: IProfileInfo = response;
        this.firstName = profileInfo.firstName;
        this.lastName = profileInfo.lastName;
        this.consultingLevel = profileInfo.consultingLevelName;
        this.region = profileInfo.regionName;
        this.name = this.firstName + ' ' + this.lastName;
        this.verified = profileInfo.verified;
        this.idProfile = profileInfo.idProfile;
      }, error => {
        alert('error');
      }
    );
  }

  getAllTechAreas(): void {
    this.skillService.getAllTechAreas().subscribe(
      (dataaa) => {

        this.myskills = dataaa;
        console.log(this.skills);

      },
      (error) => {

        console.log('error');
      }
    );
  }

  getAllTechAreas2(): void {
    this.skillService.getAllTechAreas().subscribe(
      (dataaa) => {

        this.techAreas = dataaa;
        console.log(this.skills);

      },
      (error) => {

        console.log('error');
      }
    );
  }

  saveSkill1(param: any, level: any): void {
    this.insertSkill = param;
    alert(this.insertSkill);
    this.skillLevel = level;
    alert(this.skillLevel);
    this.insertSkill = 'CPP';
    this.skillService.idSKill(this.insertSkill).subscribe(data => {
      this.idSkill = data;
      this.skillLevel = +this.skillLevel;
      this.skillService.saveProfileSkill(this.idProfile, this.idSkill, this.skillLevel).subscribe(dataa => {
        alert('new skill saved');
      }, error => {
        alert('error');
      });
    }, error => {
      alert('error');
    });
  }


  saveSkill(param: any, level: any): void {
    alert('hello');
    this.insertSkill = param;
    this.skillLevel = level;
    this.skillService.idSKill(this.insertSkill).subscribe(value => {
      this.idSkill = value;
      this.skillLevel = +this.skillLevel;
      if ((this.idSkill === -1) && (this.insertSkill !== '') && (this.techArea !== '')) {
        this.skillService.saveSkill(this.insertSkill, this.techArea).subscribe(
          response => {
            this.skillService.idSKill(this.insertSkill).subscribe(data => {
              this.idSkill = data;
              this.skillService.saveProfileSkill(this.idProfile, this.idSkill, this.skillLevel).subscribe(dataa => {
                alert('saved in your profile');
              }, error => {
                alert('error');
              });
            }, error => {
              alert('error');
            });

          },
          error => {
            alert('There was an error');
          }
        );
      } else {
        alert('enter else statment');
        this.skillLevel = +this.skillLevel;
        this.skillService.saveProfileSkill(this.idProfile, this.idSkill, this.skillLevel).subscribe(dataa => {
          alert('saved in your profile');
        }, error => {
          alert('error');
        });

      }

    }, error => {
      alert('wrong');
    });
  }

  cancelEdit(): void {
    window.location.reload();
  }

  openDrawer($event: MouseEvent): void {
    // @ts-ignore
    $event.currentTarget.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="#DC3545" class="bi bi-x" viewBox="0 0 10 16">' +
      '<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>' +
      '</svg>';
    // @ts-ignore
    $event.currentTarget.addEventListener('click', this.cancelEdit);
    // @ts-ignore
    document.getElementById('profileUI').style.width = '40%';
    // @ts-ignore
    document.getElementById('addSkillDrawer').style.display = 'initial';
  }

  setVerified(): void {
    alert(this.id);
    this.profileService.setVerified(this.id).subscribe((data) => {
      alert('User is now verified');
    }, (error) => {
      alert('something went worng');
    });
  }

  setNotVerified(): void {
    alert(this.id);
    this.profileService.setVerified(this.id).subscribe((data) => {
      alert('User is now not verified');
    }, (error) => {
      alert('something went worng');
    });
  }
}
