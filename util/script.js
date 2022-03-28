import http from 'k6/http';
import { sleep } from 'k6';

export default function () {
  http.get('http://ec2-18-212-170-90.compute-1.amazonaws.com:8080/api/v1/hitmans');
  sleep(1);
}
