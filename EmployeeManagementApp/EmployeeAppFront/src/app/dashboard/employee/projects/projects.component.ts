import {Component, Input, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IProjectInfo } from './projectInfo';
import {ProjectsService} from '../../../services/projects.service';
import {ProfileService} from '../../../services/profile.service';
import {IProjectInfoArray} from './projectInfoArray';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html'
})
export class ProjectsComponent implements OnInit {
  @Input() userId: string | undefined;
  public list: IProjectInfoArray[] = [];
  public selectedId = -1;

  constructor(private service: ProjectsService, private ps: ProfileService, private http: HttpClient) { }

  ngOnInit(): void {
    // @ts-ignore
    this.service.getList(window.location.href.split('/').pop()).subscribe(
      response3 => {
        console.log(response3);
        response3.forEach((e: string) => {
          console.log(e);
          // @ts-ignore
          this.service.get(e).subscribe(response =>
            {
              const response2 = {response, id: 1};
              console.log(response2);
              this.list.push(response2);
            },
            error => {
              alert('There was an error retrieving the projects.');
            });
        });
      },
      error => {}
      );
  }

  isOwner(): boolean {
    return localStorage.getItem('id') === this.userId;
  }

  public finish(): void {
    console.log('hello');
  }

  cancel(): void {
    window.location.reload();
  }

  edit($event: MouseEvent): void {

    // @ts-ignore
    $event.currentTarget.parentElement.parentElement.getElementsByClassName('project-title')[0].outerHTML =
      '<input type="text" id="project-title" style="width: 20%; display:initial;" class="form-control" value="' +
      // @ts-ignore
      $event.currentTarget.parentElement.parentElement.getElementsByClassName('project-title')[0].innerText + '">';

    // @ts-ignore
    $event.currentTarget.parentElement.parentElement.getElementsByClassName('project-client')[0].outerHTML =
      '<input type="text" id="project-client" class="form-control" style="width: 20%; display:initial; margin-top: .5rem" value="' +
      // @ts-ignore
      $event.currentTarget.parentElement.parentElement.getElementsByClassName('project-client')[0].innerText + '">';

    // // @ts-ignore
    // $event.currentTarget.parentElement.parentElement.getElementsByClassName('project-role')[0].outerHTML =
    //   '<input type="text" class="form-control" style="width: 10%; display:initial; margin-left: .5rem" value="' +
    //   // @ts-ignore
    //   $event.currentTarget.parentElement.parentElement.getElementsByClassName('project-role')[0].innerText + '">';

    // @ts-ignore
    $event.currentTarget.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="#198754" class="bi bi-check" viewBox="0 0 10 16">' +
      '<path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>' +
      '</svg>';

    // @ts-ignore
    $event.currentTarget._selectedId = $event.currentTarget.parentElement.parentElement
      .getElementsByClassName('project-id')[0].value;

    // @ts-ignore
    // $event.currentTarget.onclick = this.finish;
    // tslint:disable-next-line:typedef only-arrow-functions
    $event.currentTarget.addEventListener('click', (event) => {
      // @ts-ignore
      const id = event.currentTarget._selectedId;
      // @ts-ignore
      const title = event.currentTarget.parentElement.parentElement.childNodes[3].value;
      // @ts-ignore
      const duration = event.currentTarget.parentElement.parentElement.childNodes[5].innerText.split(' ');
      // @ts-ignore
      console.log(event.currentTarget.parentElement.parentElement.childNodes[5]);
      // @ts-ignore
      const customer = event.currentTarget.parentElement.parentElement.childNodes[7].value;
      // @ts-ignore
      const description = event.currentTarget.parentElement.parentElement.childNodes[10].value;

      this.service.update(id, customer, description, duration[0], '1', title).subscribe(response =>
        {
          alert('Project updated.');
        },
        error => {
          alert('There was an error.');
        });
      this.setNotVerified();
      window.location.reload();
    });

    // @ts-ignore
    $event.currentTarget.parentElement.childNodes[1].innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="#DC3545" class="bi bi-x" viewBox="0 0 10 16">' +
    '<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>' +
      '</svg>';
    // @ts-ignore
    $event.currentTarget.parentElement.childNodes[1].onclick = this.cancel;

    // @ts-ignore
    $event.currentTarget.parentElement.parentElement.getElementsByClassName('project-description')[0].outerHTML = '<textarea class="form-control mb-2" id="project-description" placeholder="Description">'
      // @ts-ignore
      + $event.currentTarget.parentElement.parentElement.getElementsByClassName('project-description')[0].innerText + '</textarea>';
    // // @ts-ignore
    // const skills = $event.currentTarget.parentElement.parentElement.getElementsByClassName('skill-badge');
    // // @ts-ignore
    // for (let i = 0; i < skills.length; i++){
    //   // @ts-ignore
    //   skills.item(i).innerHTML += '<a>&times;</a>';
    // }
  }

  setNotVerified(): void {
    // @ts-ignore
    this.ps.setNotVerified(parseInt(window.location.href.split('/').pop(), 10)).subscribe((data) => {
      alert('User is now not verified');
    }, (error) => {
      alert('something went wrong');
    });
  }

  remove($event: MouseEvent): void {
    // @ts-ignore
    const id = $event.currentTarget.parentElement.parentElement
      .getElementsByClassName('project-id')[0].value;
    this.service.delete(id).subscribe(result => { alert('Project deleted');
      }, error => {
        alert('Error');
      }
    );
    //window.location.reload();
  }
}
