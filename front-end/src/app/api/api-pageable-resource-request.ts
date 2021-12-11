export class PageableResource<T> {
  content: T;
  number: number;
  size: number;
  totalElements: number;
}

export class ApiPageableResourceRequest<T> {
  data: PageableResource<T>;
  loading: boolean;
  error: any;
}
